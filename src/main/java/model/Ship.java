package model;

import model.cell.Cell;

public class Ship
{
    private final Cell[] ship;

    public Ship(Cell[] cells)
    {
        ship = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++)
        {
            cells[i].setShip();
            ship[i] = cells[i];
        }
    }

    public Cell[] getShip()
    {
        return ship;
    }

    public boolean isDestroyed()
    {
        for (Cell cell : ship)
        {
            if (!cell.isBombed())
            {
                return false;
            }
        }
        return true;
    }
}
