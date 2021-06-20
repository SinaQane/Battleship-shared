package event.events;

import event.Event;
import event.EventVisitor;
import response.Response;

public class TimeoutEvent extends Event
{
    String kind;

    public TimeoutEvent(String kind)
    {
        this.kind = kind;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.timeout(kind);
    }
}
