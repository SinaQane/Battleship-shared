package event.events.gameplay;

import event.Event;
import event.EventVisitor;
import response.Response;

public class GetBoardEvent extends Event
{
    private final String authToken;

    public GetBoardEvent(String authToken)
    {
        this.authToken = authToken;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.getBoard(authToken);
    }
}