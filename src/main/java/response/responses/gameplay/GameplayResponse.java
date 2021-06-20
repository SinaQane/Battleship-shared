package response.responses.gameplay;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

// Used as a response both to GameMoveEvent and GetBoardEvent
public class GameplayResponse extends Response
{
    private final Game game;

    public GameplayResponse(Game game)
    {
        this.game = game;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.gameplay(game);
    }
}
