package endpoints;

        import clientObject.ChatCreated;
        import clientObject.ConnectInfo;
        import clientObject.InterlocutorInfo;
        import clientObject.UserInfo;
        import com.google.gson.Gson;
        import person.Person;

        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;
        import java.util.ArrayList;

        import objecttype.ObjectType;
        import room.PairRoom;

@ServerEndpoint(value = "/chat"/*,decoders = {MessageDecoder.class},encoders = {MessageEncoder.class}*/)
public class ChatEndpoints {
    private Session session=null;
    //private  static List<Session> generalChatSessionList = new LinkedList<>();

    // new variable
    private Person person = new Person();
    private static ArrayList<PairRoom> pairRoomArrayList= new ArrayList<>();
    public int roomIndex;
    public boolean createRoom = false;




    @OnOpen
    public  void onOpen (Session session)
    {
        this.session = session;
        person.setSession(this.session);
    }

    @OnClose
    public  void onClose(Session session)
    {
       System.err.println("Room "+roomIndex+" deleted");
        pairRoomArrayList.remove(roomIndex);
    }
    @OnError
    public  void onError (Session session,Throwable throwable)
    {
        System.err.println(throwable);
    }

    @OnMessage
    public  void  onMessage(Session session, String stringJson)
    {
        System.out.println(stringJson);

     //   System.out.println(objectInfo(stringJson));




        if (objectInfo(stringJson).toString().equals("Message")) {
            sendInPairChat(pairRoomArrayList.get(roomIndex),stringJson);
        }

        if (objectInfo(stringJson).toString().equals("UserInfo")) {
            UserInfo userInfo = new UserInfo();
            userInfo = (UserInfo)ObjectType.getObject(stringJson,userInfo);
            person.setName(userInfo.getName());
            person.setAge(Integer.parseInt(userInfo.getAge()));
            person.setGender(userInfo.getGender());
            person.setVoiceMessage(userInfo.isVoiceMessage());
        }

        if(objectInfo(stringJson).toString().equals("ConnectInfo")) {
            ConnectInfo connectInfo = new ConnectInfo();
            connectInfo = (ConnectInfo) ObjectType.getObject(stringJson, connectInfo);
            person.setChatType(connectInfo.getChatType());
        }

        if (objectInfo(stringJson).toString().equals("InterlocutorInfo")) {
            InterlocutorInfo interlocutorInfo = new InterlocutorInfo();
            interlocutorInfo = (InterlocutorInfo)ObjectType.getObject(stringJson,interlocutorInfo);
            person.setInterlocutorGender(interlocutorInfo.getGender());
            person.setInterlocutorAgeFrom(Integer.parseInt(interlocutorInfo.getAgeFrom()));
            person.setInterlocutorAgeTo(Integer.parseInt(interlocutorInfo.getAgeTo()));
            person.setCreated(true);
        }



        if(person.isCreated()&& createRoom==false) {
            createOrJoinInRoom();
            createRoom = true;
        }

    }



    private StringBuffer objectInfo(String json){
        StringBuffer returnJson = new StringBuffer();
        int count =0;
        for(int i=0;i<json.length();i++)
        {
            if(json.charAt(i)=='\"')
            {
                count++;
            }
            if (count==3){
                returnJson.append(json.charAt(i));
            }
        }
        returnJson.deleteCharAt(0);
        return returnJson;
    }




    private void sendInPairChat(PairRoom room,String message)
    {
        room.getPersonArrayList().forEach(s->{
        if(s==person) return;
        try {
            s.getSession().getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    }

    private void createOrJoinInRoom()
    {
        System.err.println(person.toString());
        if(pairRoomArrayList.isEmpty())
        {
            create(0);
        }
        else {
            for(int i=0;i<pairRoomArrayList.size();i++)
            {
                Person localPerson = pairRoomArrayList.get(i).getPerson();
                PairRoom localRoom = pairRoomArrayList.get(i);
                if(localRoom.isOpen())
                {
                    if(localPerson.getGender().equals(this.person.getInterlocutorGender()))
                    {
                        if(localPerson.getAge()>=this.person.getInterlocutorAgeFrom() && localPerson.getAge()<=this.person.getInterlocutorAgeTo())
                        {
                            if(this.person.getGender().equals(localPerson.getInterlocutorGender()))
                            {
                                if(this.person.getAge()>=localPerson.getInterlocutorAgeFrom()&&this.person.getAge()<=localPerson.getInterlocutorAgeTo())
                                {
                                    pairRoomArrayList.get(i).addPerson(this.person);
                                    pairRoomArrayList.get(i).setOpen(false);
                                    System.err.println("Room is closed");
                                    System.err.println("in room "+pairRoomArrayList.get(i).getPersonArrayList().get(0).getName()+" and "+pairRoomArrayList.get(i).getPersonArrayList().get(1).getName());
                                    try {
                                        pairRoomArrayList.get(i).getPersonArrayList().get(0).getSession().getBasicRemote().sendText("created");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        pairRoomArrayList.get(i).getPersonArrayList().get(1).getSession().getBasicRemote().sendText("created");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return;
                                }
                                else if(i==pairRoomArrayList.size()-1)
                                {
                                    create(i);
                                    return;
                                }
                            }
                            else if(i==pairRoomArrayList.size()-1)
                            {
                                create(i);
                                return;
                            }
                        }
                        else if(i==pairRoomArrayList.size()-1)
                        {
                            create(i);
                            return;
                        }
                    }
                    else if(i==pairRoomArrayList.size()-1)
                    {
                        create(i);
                        return;
                    }
                }
                else if(i==pairRoomArrayList.size()-1)
                {
                    create(i);
                    return;
                }
            }
        }
        createRoom = true;
    }

    private void create(int index){
        PairRoom pairRoom = new PairRoom();
        pairRoom.setOpen(true);
        pairRoom.addPerson(this.person);
        pairRoomArrayList.add(pairRoom);
        roomIndex = index;
        System.err.println("ROOM CREATED index "+ index);
    }



}
