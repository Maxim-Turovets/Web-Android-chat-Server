package endpoints;

import javax.websocket.OnOpen;
import javax.websocket.Session;
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
}
