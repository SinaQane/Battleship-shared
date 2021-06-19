package response.responses.authentication;

import response.Response;
import response.ResponseVisitor;

public class SignupResponse extends Response
{
    String response;

    public SignupResponse(String response)
    {
        this.response = response;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.signupResponse(response);
    }
}
