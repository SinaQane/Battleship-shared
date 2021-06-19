package event.events.authentication;

import event.Event;
import event.EventVisitor;
import response.Response;

public class LoginEvent extends Event
{
    String username, password;

    public LoginEvent(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.login(username, password);
    }
}
