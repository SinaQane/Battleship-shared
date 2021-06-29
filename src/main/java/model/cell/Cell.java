package model.cell;

public class Cell
{
    private final int[] coordinates = new int[2];
    private boolean bombed;
    private boolean ship;

    public Cell(int x, int y)
    {
        coordinates[0] = x;
        coordinates[1] = y;
        bombed = false;
        ship = false;
    }

    public void setShip()
    {
        ship = true;
    }

    public void setBombed(boolean bombed)
    {
        this.bombed = bombed;
    }

    public CellStatus getStatus()
    {
        if (!ship)
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

    public boolean getShip()
    {
        return ship;
    }

    public boolean isBombed()
    {
        return bombed;
    }
}
