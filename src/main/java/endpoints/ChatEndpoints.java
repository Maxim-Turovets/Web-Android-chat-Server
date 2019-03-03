package endpoints;

        import javax.websocket.*;
        import javax.websocket.server.ServerEndpoint;
        import java.util.LinkedList;
        import java.util.List;

@ServerEndpoint(value = "/chat")
public class ChatEndpoints {
    private Session session=null;
    private  static List<Session> sessionList = new LinkedList<>();

    @OnOpen
    public  void onOpen (Session session)
    {
        this.session= session;
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

    @OnMessage
    public  void  onMessage(Session session, String)
}
