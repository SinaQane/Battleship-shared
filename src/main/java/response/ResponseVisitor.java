package response;

import model.Board;
import model.game.Game;
import model.User;

public interface ResponseVisitor
{
    // authentication responses

    void loginResponse(User user, String response, String authToken);

    void signupResponse(String response);

    void logoutResponse(String response);

    // gameplay responses

    void gameplay(Game game);

    // menu responses

    void gamesList(Game[] games);

    void scoreboard(User[] users);

    void viewGame(Game game);

    void changeFrame(String frame);

    // start game responses

    void pickBoard(Board[] boards);

    void startGame(Game game, int side);
}
