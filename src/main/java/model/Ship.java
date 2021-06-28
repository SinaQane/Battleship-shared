package model;

import model.cell.Cell;
import model.cell.CellStatus;

public class Ship
{
    private final transient Cell[] ship;

    public Ship(Cell[] cells)
    {
        ship = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++)
        {
            cells[i].setShip();
            ship[i] = cells[i];
        }
    }

    public boolean isDestroyed()
    {
        for (Cell cell : ship)
        {
            if (!cell.getStatus().equals(CellStatus.DESTROYED))
            {
                return false;
            }
        }
        return true;
    }
}
