package event.events.gameplay;

import event.Event;
import event.EventVisitor;
import response.Response;

public class ResignEvent extends Event
{
    private final String authToken;

    public ResignEvent(String authToken)
    {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.resign(authToken);
    }
}
