package event.events.authentication;

import event.Event;
import event.EventVisitor;
import response.Response;

public class LogoutEvent extends Event
{
    private final String authToken;

    public LogoutEvent(String authToken)
    {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.logout(authToken);
    }
}
