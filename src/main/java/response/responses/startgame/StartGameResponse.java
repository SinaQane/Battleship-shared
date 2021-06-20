package response.responses.startgame;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

public class StartGameResponse extends Response
{
    private final Game game;

    public StartGameResponse(Game game)
    {
        this.game = game;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.startGame(game);
    }
}