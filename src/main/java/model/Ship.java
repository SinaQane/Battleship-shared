package model;

import model.cell.Cell;
import model.cell.CellStatus;

public class Ship
{
    private final Cell[] shipCells;

    public Ship(Cell[] cells)
    {
        shipCells = new Cell[cells.length];
        int index = 0;
        for (Cell cell : cells)
        {
            cell.setShip(this);
            shipCells[index] = cell;
            index++;
        }
    }

    public boolean isDestroyed()
    {
        for (Cell cell : shipCells)
        {
            if (!cell.getStatus().equals(CellStatus.DESTROYED))
            {
                return false;
            }
        }
        return true;
    }
}
