package event.events.authentication;

import event.Event;
import event.EventVisitor;
import response.Response;

public class SignupEvent extends Event
{
    private final String username, password;

    public SignupEvent(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.signup(username, password);
    }
}
