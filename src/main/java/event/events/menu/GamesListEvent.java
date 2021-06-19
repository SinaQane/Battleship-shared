package event.events.menu;

import event.Event;
import event.EventVisitor;
import response.Response;

public class GamesListEvent extends Event
{
    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.gamesList();
    }
}
