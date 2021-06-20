package response.responses.startgame;

import model.Board;
import response.Response;
import response.ResponseVisitor;

public class PickBoardResponse extends Response
{
    private final Board[] boards;

    public PickBoardResponse(Board[] boards)
    {
        this.boards = boards;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor)
    {
        responseVisitor.pickBoard(boards);
    }
}
