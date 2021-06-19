package event.events.authentication;

import event.Event;
import event.EventVisitor;
import response.Response;

public class LogoutEvent extends Event
{
    String authToken, username;

    public LogoutEvent(String authToken, String username)
    {
        this.authToken = authToken;
        this.username = username;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.logout(authToken, username);
    }
}
