package endpoints;

        import coders.MessageDecoder;
        import coders.MessageEncoder;
        import entities.Message;
        import room.Room;

        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;

@ServerEndpoint(value = "/chat",decoders = {MessageDecoder.class},encoders = {MessageEncoder.class})
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
        isConnected =true;
    }

    @OnClose
    public  void onClose(Session session)
    {
        generalChatSessionList.remove(this.session);
        roomList.remove(index);
    }
    @OnError
    public  void onError (Session session,Throwable throwable)
    {
        throwable.printStackTrace();
    }

    @OnMessage
    public  void  onMessage(Session session, Message msg)
    {

        if(isConnected==true) {
            System.out.println("Client "+session.getId());
            if (setChatType(msg).equals("general")) {
                generalChatSessionList.add(this.session);
                isConnected = false;
            }
            if (setChatType(msg).equals("pair")) {
                pairChatSessionList.add(this.session);
                setClientToRoom();
                isConnected= false;
            }
        }

            if (setChatType(msg).equals("general")) {
                sendMessagesGeneralChat(msg);
            }
            if (setChatType(msg).equals("pair")) {
                sendMessagesRoomChat(msg);
            }

    }


private void sendMessagesGeneralChat(Message message) // разослать в общем чате
{
    generalChatSessionList.forEach(s->{
        if(s==this.session) return;
        try {
            s.getBasicRemote().sendObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    });
}

private  String  setChatType(Message messageClient)
{
    if (messageClient.getAuthkey().equals("pair"))
        return "pair";
    if(messageClient.getAuthkey().equals("general"))
        return "general";
    else
        return "";
}

private void setClientToRoom()
{
    boolean y = false;

    for(int i=0;i<roomList.size();i++)
    {
        if (roomList.get(i).getStatus()==true) {
            System.out.println("Room close");
            roomList.get(i).addElement(this.session);
            y = true;
            roomList.get(i).setStatus(false);
            break;
        }
    }
    if (y==false)
    {
            Room room = new Room();
            room.addElement(this.session);
            room.setStatus(true);
            roomList.add(room);
            index = roomList.size()-1;
        System.out.println("Room create " + index);
    }



      pairChatSessionList.remove(0);



}

    private void sendMessagesRoomChat(Message message)    // разослать в room
    {
        String msg = message.getName();
        message.setName("(private room) " + msg);
        System.out.println("Index " + index);

        try {
            if (this.session == roomList.get(index).getClientList().get(0)) {
                System.out.println("1 Session");
                try {
                    roomList.get(index).getClientList().get(1).getBasicRemote().sendObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (EncodeException e) {
                    e.printStackTrace();
                }
            }

            if (this.session == roomList.get(index).getClientList().get(1)) {
                System.out.println("2 Session");
                try {
                    roomList.get(index).getClientList().get(0).getBasicRemote().sendObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (EncodeException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("To client not create");
        }

    }
}
