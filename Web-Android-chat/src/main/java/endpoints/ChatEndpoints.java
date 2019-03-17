package endpoints;

        import clientObject.ConnectInfo;
        import clientObject.UserInfo;
        import entities.Message;
        import room.Room;

        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import objecttype.ObjectType;

@ServerEndpoint(value = "/chat"/*,decoders = {MessageDecoder.class},encoders = {MessageEncoder.class}*/)
public class ChatEndpoints {
    private Session session=null;
    private  static List<Session> generalChatSessionList = new LinkedList<>();
    private  static List<Session> pairChatSessionList = new ArrayList<>();
    private  static List<Room>    roomList = new ArrayList<>();
    public  int index= roomList.size()-1;
    public boolean isConnected=false;



    @OnOpen
    public  void onOpen (Session session)
    {
        this.session = session;
        isConnected = true;
    }

    @OnClose
    public  void onClose(Session session)
    {
        generalChatSessionList.remove(this.session);
        try {
            roomList.remove(index);
        }
        catch (Exception e)
        {
            System.err.println("Room is deleted");
        }
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

        System.out.println(objectInfo(stringJson));

        if (objectInfo(stringJson).toString().equals("UserInfo")) {
            UserInfo userInfo = new UserInfo();
            userInfo = (UserInfo) ObjectType.getObject(stringJson, userInfo);
            System.err.println("Name : "+userInfo.getName());
            System.err.println("Gender : "+userInfo.getGender());
            System.err.println("Age : "+userInfo.getAge());
            System.err.println("Voice : "+userInfo.isVoiceMessage());
        }

        if(objectInfo(stringJson).toString().equals("ConnectInfo")) {
            ConnectInfo connectInfo = new ConnectInfo();
            connectInfo = (ConnectInfo) ObjectType.getObject(stringJson, connectInfo);
            System.err.println("Chat type : "+connectInfo.getChatType());
        }








    }


private void sendMessagesGeneralChat(Message message) // разослать в общем чате
{
    generalChatSessionList.forEach(s->{
        if(s==this.session) return;
        try {
            s.getBasicRemote().sendText(ObjectType.getJson(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
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
}
