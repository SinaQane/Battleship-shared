package response.responses.startgame;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

public class StartGameResponse extends Response
{
    private final Game game;
    private final int side;

    public StartGameResponse(Game game, int side)
    {
        this.game = game;
        this.side = side;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.startGame(game, side);
    }
}