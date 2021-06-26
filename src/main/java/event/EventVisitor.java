package event;

import model.Board;
import model.game.Game;
import response.Response;

// TODO ClientHandler (server) and MainController (client) should have a User and Token attribute
public interface EventVisitor
{
    // general events

    Response timeout(String kind);

    // authentication events

    Response login(String username, String password);

    Response signup(String username, String password);

    Response logout(String authToken);

    // gameplay events

    Response gameMove(String authToken, int x, int y);

    Response getBoard(String authToken);

    // menu events

    Response gamesList();

    Response scoreboard();

    Response viewGame(int index);

    // start game events

    Response pickBoard(String authToken);

    Response startGame(String authToken, Board board);
}
