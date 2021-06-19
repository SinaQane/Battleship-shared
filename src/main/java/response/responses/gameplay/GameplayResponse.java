package response.responses.gameplay;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

public class GameplayResponse extends Response
{
    Game game;

    public GameplayResponse(Game game)
    {
        this.game = game;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.viewGame(game);
    }
}
