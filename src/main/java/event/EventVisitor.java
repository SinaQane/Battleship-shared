package event;

import model.Board;
import response.Response;

public interface EventVisitor
{
    // authentication events

    Response login(String username, String password);

    Response signup(String username, String password);

    Response logout(String authToken);

    // gameplay events

    Response gameMove(String authToken, int x, int y);

    Response getBoard(String authToken);

    Response resign(String authToken);

    // menu events

    Response gamesList();

    Response scoreboard();

    Response viewGame(int index);

    Response changeFrame(String frame);

    // start game events

    Response pickBoard(String authToken);

    Response startGame(String authToken, Board board);
}
