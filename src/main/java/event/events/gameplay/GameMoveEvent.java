package event.events.gameplay;

import event.Event;
import event.EventVisitor;
import response.Response;

public class GameMoveEvent extends Event
{
    String authToken;
    int x, y;

    public GameMoveEvent(String authToken, int x, int y)
    {
        this.authToken = authToken;
        this.x = x;
        this.y = y;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.gameMove(authToken, x, y);
    }
}
