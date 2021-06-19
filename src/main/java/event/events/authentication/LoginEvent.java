package event.events.authentication;


import event.Event;
import event.EventVisitor;
import response.Response;

public class LoginEvent extends Event
{

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return null;
    }
}
