package response;

import model.game.Game;
import model.User;

public interface ResponseVisitor
{
    void loginResponse(String response, String token);

    void signupResponse(String response);

    void scoreboard(User[] users);

    void gamesList(Game[] games);

    void viewGame(Game game);
}
