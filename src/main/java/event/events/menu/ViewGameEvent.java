package event.events.menu;

import event.Event;
import event.EventVisitor;
import response.Response;

public class ViewGameEvent extends Event
{
    private final int index;

    public ViewGameEvent(int index)
    {
        this.index = index;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.viewGame(index);
    }
}
