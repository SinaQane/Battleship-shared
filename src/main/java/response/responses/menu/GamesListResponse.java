package response.responses.menu;

import model.game.Game;
import response.Response;
import response.ResponseVisitor;

public class GamesListResponse extends Response
{
    Game[] games;

    public GamesListResponse (Game[] games)
    {
        this.games = games;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.gamesList(games);
    }
}