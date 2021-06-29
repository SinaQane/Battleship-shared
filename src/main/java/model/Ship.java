package model;

import model.cell.Cell;

import java.util.LinkedList;
import java.util.List;

public class Ship
{
    private final List<Integer[]> ship = new LinkedList<>();

    public Ship(List<Cell> cells)
    {
        for (Cell cell : cells)
        {
            cell.setShip();
            ship.add(new Integer[]{cell.getCoordinates()[0], cell.getCoordinates()[1]});
        }
    }

    public List<Integer[]> getShip()
    {
        return ship;
    }
}
