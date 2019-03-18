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




    @OnOpen
    public  void onOpen (Session session)
    {
        this.session = session;
        person.setSession(this.session);
    }

    @OnClose
    public  void onClose(Session session)
    {


    }
    @OnError
    public  void onError (Session session,Throwable throwable)
    {
        //System.err.println("Session close");
        System.out.println(throwable);
    }

    @OnMessage
    public  void  onMessage(Session session, String stringJson)
    {
        System.out.println(stringJson);

     //   System.out.println(objectInfo(stringJson));

        ChatCreated chatCreated = new ChatCreated();


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

        if(person.isCreated()) {
            System.err.println(person.toString());
            if(pairRoomArrayList.isEmpty())
            {
                PairRoom pairRoom = new PairRoom();
                pairRoom.setOpen(true);
                pairRoom.addPerson(person);
                pairRoomArrayList.add(pairRoom);
                System.err.println("ROOM CREATED");
            }
            else {
                for(int i=0;i<pairRoomArrayList.size();i++)
                {
                  if( pairRoomArrayList.get(i).isOpen())
                  {
                      if(pairRoomArrayList.get(i).getPerson().getGender().equals(this.person.getInterlocutorGender()))
                      {
                          if(pairRoomArrayList.get(i).getPerson().getAge()>=this.person.getInterlocutorAgeFrom() && pairRoomArrayList.get(i).getPerson().getAge()<=this.person.getInterlocutorAgeTo())
                          {
                              if(this.person.getGender().equals(pairRoomArrayList.get(i).getPerson().getInterlocutorGender()))
                              {
                                  if(pairRoomArrayList.get(i).getPerson().getAge()>=this.person.getInterlocutorAgeFrom() && pairRoomArrayList.get(i).getPerson().getAge()<=this.person.getInterlocutorAgeTo())
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
                                  else
                                  {
                                      PairRoom pairRoom = new PairRoom();
                                      pairRoom.setOpen(true);
                                      pairRoom.addPerson(person);
                                      pairRoomArrayList.add(pairRoom);
                                      System.err.println("ROOM CREATED 5");
                                      return;
                                  }
                              }
                              else
                              {
                                  PairRoom pairRoom = new PairRoom();
                                  pairRoom.setOpen(true);
                                  pairRoom.addPerson(person);
                                  pairRoomArrayList.add(pairRoom);
                                  System.err.println("ROOM CREATED 4");
                                  return;
                              }
                          }
                          else
                          {
                              PairRoom pairRoom = new PairRoom();
                              pairRoom.setOpen(true);
                              pairRoom.addPerson(person);
                              pairRoomArrayList.add(pairRoom);
                              System.err.println("ROOM CREATED 3");
                              return;
                          }
                      }
                      else
                      {
                          PairRoom pairRoom = new PairRoom();
                          pairRoom.setOpen(true);
                          pairRoom.addPerson(person);
                          pairRoomArrayList.add(pairRoom);
                          System.err.println("ROOM CREATED 2");
                          return;
                      }
                  }
                }
            }
        }











    }


//private void sendMessagesGeneralChat(Message message) // разослать в общем чате
//{
//    generalChatSessionList.forEach(s->{
//        if(s==this.session) return;
//        try {
//            s.getBasicRemote().sendText(ObjectType.getJson(message));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    });
//}


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


    public   class СhatСreated {
        public String getStringJson() {
            return stringJson;
        }

        public void setStringJson(String stringJson) {
            this.stringJson = stringJson;
        }

        private String stringJson = "created";
    }

}
