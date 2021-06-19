package model;

import model.cell.Cell;

public class Board
{
    private final Cell[][] board = new Cell[10][10];

    public Board()
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int x, int y)
    {
        return board[x][y];
    }

    public Cell[][] getBoard()
    {
        return board;
    }
}
