package model.cell;

import model.Ship;

public class Cell
{
    private Ship ship;
    private boolean hit;

    public Cell()
    {
        hit = false;
        ship = null;
    }

    public void setShip(Ship ship)
    {
        this.ship = ship;
    }

    public void setHit(boolean hit)
    {
        this.hit = hit;
    }

    public Ship getShip()
    {
        return ship;
    }

    public CellStatus getStatus()
    {
        if (ship == null)
        {
            if (!hit)
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
            if  (!hit)
            {
                return CellStatus.SHIP;
            }
            else
            {
                return CellStatus.DESTROYED;
            }
        }
    }
}
