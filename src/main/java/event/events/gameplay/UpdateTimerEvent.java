package event.events.gameplay;

import event.Event;
import event.EventVisitor;
import response.Response;

public class UpdateTimerEvent extends Event
{
    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.updateTimer();
    }
}
