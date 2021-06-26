package response.responses.menu;

import response.Response;
import response.ResponseVisitor;

public class ChangeFrameResponse extends Response
{
    private final String frame;

    public ChangeFrameResponse (String frame)
    {
        this.frame = frame;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.changeFrame(frame);
    }
}
