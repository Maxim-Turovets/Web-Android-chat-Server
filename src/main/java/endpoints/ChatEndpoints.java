package endpoints;

        import coders.MessageDecoder;
        import coders.MessageEncoder;
        import entities.Message;

        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;
        import java.util.LinkedList;
        import java.util.List;

@ServerEndpoint(value = "/chat",decoders = {MessageDecoder.class},encoders = {MessageEncoder.class})
public class ChatEndpoints {
    private Session session=null;
    public  static int counter = 0;
    private  static List<Session> sessionList = new LinkedList<>();

    @OnOpen
    public  void onOpen (Session session)
    {
        counter++;
        this.session = session;
        sessionList.add(session);
    }

    @OnClose
    public  void onClose(Session session)
    {
        sessionList.remove(this.session);
    }
    @OnError
    public  void onError (Session session,Throwable throwable)
    {
        throwable.printStackTrace();
    }

//    @OnMessage
//    public  void  onMessage(Session session, Message msg)
//    {
//        sessionList.forEach(s->{
//            if(s==this.session) return;
//            try {
//                s.getBasicRemote().sendObject(msg);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (EncodeException e) {
//                e.printStackTrace();
//            }
//        });
//    }

    @OnMessage
    public  void  onMessage(Session session,String str) throws IOException {


        for(int i = 0;i<sessionList.size();i++)
        {
            if(sessionList.get(i)==session)
            continue;
            else
                sessionList.get(i).getBasicRemote().sendText(str);
        }
    }






}
