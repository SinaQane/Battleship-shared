package response.responses.authentication;

import response.Response;
import response.ResponseVisitor;

public class LogoutResponse extends Response
{
    String response;

    public LogoutResponse(String response)
    {
        this.response = response;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.logoutResponse(response);
    }
}
