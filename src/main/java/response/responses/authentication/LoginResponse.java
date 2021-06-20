package response.responses.authentication;

import response.Response;
import response.ResponseVisitor;

public class LoginResponse extends Response
{
    private final String response, authToken;

    public LoginResponse(String response, String authToken)
    {
        this.response = response;
        this.authToken = authToken;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.loginResponse(response, authToken);
    }
}
