package response.responses.menu;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

public class ViewGameResponse extends Response
{
    private final Game game;

    public ViewGameResponse(Game game)
    {
        this.game = game;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.viewGame(game);
    }
}
