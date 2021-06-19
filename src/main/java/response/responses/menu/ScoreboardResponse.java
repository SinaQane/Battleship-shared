package response.responses.menu;

import model.User;
import response.Response;
import response.ResponseVisitor;

public class ScoreboardResponse extends Response
{
    User[] users;

    public ScoreboardResponse (User[] users)
    {
        this.users = users;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.scoreboard(users);
    }
}
