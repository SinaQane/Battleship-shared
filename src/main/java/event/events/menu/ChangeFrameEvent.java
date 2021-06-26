package event.events.menu;

import event.Event;
import event.EventVisitor;
import response.Response;

public class ChangeFrameEvent extends Event
{
    private final String frame;

    public ChangeFrameEvent(String frame)
    {
        this.frame = frame;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.changeFrame(frame);
    }
}
