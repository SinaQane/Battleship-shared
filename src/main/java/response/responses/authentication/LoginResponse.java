package response.responses.authentication;

import model.User;
import response.Response;
import response.ResponseVisitor;

public class LoginResponse extends Response
{
    private final String response, authToken;
    private final User user;

    public LoginResponse(User user, String response, String authToken)
    {
        this.user = user;
        this.response = response;
        this.authToken = authToken;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.loginResponse(user, response, authToken);
    }
}
