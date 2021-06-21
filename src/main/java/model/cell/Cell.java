package model.cell;

import model.Ship;

public class Cell
{
    private final int[] coordinates = new int[2];
    private boolean bombed;
    private Ship ship;

    public Cell(int x, int y)
    {
        coordinates[0] = x;
        coordinates[1] = y;
        bombed = false;
        ship = null;
    }

    public void setShip(Ship ship)
    {
        this.ship = ship;
    }

    public void setBombed(boolean bombed)
    {
        this.bombed = bombed;
    }

    public CellStatus getStatus()
    {
        if (ship == null)
        {
            if (!bombed)
            {
                return CellStatus.EMPTY;
            }
            else
            {
                return CellStatus.BOMBED;
            }
        }
        else
        {
            if  (!bombed)
            {
                return CellStatus.SHIP;
            }
            else
            {
                return CellStatus.DESTROYED;
            }
        }
    }

    public int[] getCoordinates()
    {
        return coordinates;
    }

    public Ship getShip()
    {
        return ship;
    }

    public boolean isBombed()
    {
        return getStatus().equals(CellStatus.DESTROYED) || getStatus().equals(CellStatus.BOMBED);
    }
}
