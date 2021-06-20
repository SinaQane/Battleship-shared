package event.events.startgame;

import event.Event;
import event.EventVisitor;
import model.Board;
import response.Response;

/* After selecting the board in the client, StartGameEvent will be sent to server to literally start a game. */
public class StartGameEvent extends Event
{
    private final String authToken;
    private final Board board;

    public StartGameEvent(String authToken, Board board)
    {
        this.authToken = authToken;
        this.board = board;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.startGame(authToken, board);
    }
}
