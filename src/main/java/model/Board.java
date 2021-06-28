package model;

import model.cell.Cell;

import java.util.LinkedList;
import java.util.List;

public class Board
{
    private final Cell[][] board = new Cell[10][10];
    private final List<Ship> ships = new LinkedList<>();

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

    public void setShip(List<Integer[]> coordinates)
    {
        Cell[] cells = new Cell[coordinates.size()];
        for (int i = 0; i < coordinates.size(); i++)
        {
            cells[i] = board[coordinates.get(i)[0]][coordinates.get(i)[1]];
        }
        ships.add(new Ship(cells));
    }

    public Cell getCell(int x, int y)
    {
        return board[x][y];
    }

    public List<Ship> getShips()
    {
        return ships;
    }

    public Cell[][] getBoard()
    {
        return board;
    }
}
