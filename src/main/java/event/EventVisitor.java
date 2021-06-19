package event;

import model.Board;
import model.game.Game;
import response.Response;

public interface EventVisitor
{
    // authentication events

    Response login(String username, String password);

    Response signup(String username, String password);

    Response logout(String authToken, String username);

    // gameplay events

    Response gameMove(String authToken, int x, int y);

    // menu events

    Response gamesList();

    Response scoreboard();

    Response viewGame(Game game);

    // start game events

    Response pickBoard(String authToken);

    Response startGame(String authToken, Board board);
}
