package event.events.startgame;

import event.Event;
import event.EventVisitor;
import response.Response;

/* StartGame Button in client creates a PickBoardEvent and sends it to server
Server sends back a PickBoardResponse containing three generated boards. */
public class PickBoardEvent extends Event
{
    String authToken;

    public PickBoardEvent(String authToken)
    {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.pickBoard(authToken);
    }
}
