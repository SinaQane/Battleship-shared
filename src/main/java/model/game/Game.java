package model.game;

import model.Board;
import model.User;

public class Game
{
    private final User[] players = new User[2];
    private final Board[] boards = new Board[2];
    private final int[] droppedBombs = new int[2];
    private final int[] successfulBombs = new int[2];
    private final int[] sunkenShips = new int[2];
    private String gameMessage;

    public Game(User playerOne, User playerTwo)
    {
        players[0] = playerOne;
        players[1] = playerTwo;
        boards [0] = new Board();
        boards [1] = new Board();
    }

    public void threwUnsuccessfulBomb(Side player)
    {
        droppedBombs[player.getIndex()]++;
    }

    public void threwSuccessfulBomb(Side player)
    {
        droppedBombs[player.getIndex()]++;
        successfulBombs[player.getIndex()]++;
    }

    public void lostShip(Side player)
    {
        sunkenShips[player.getIndex()]++;
    }

    public void setGameMessage(String gameMessage)
    {
        this.gameMessage = gameMessage;
    }

    public User getPlayer(Side player)
    {
        return players[player.getIndex()];
    }

    public Board getBoard(Side player)
    {
        return boards[player.getIndex()];
    }

    public int getDroppedBombs(Side player)
    {
        return droppedBombs[player.getIndex()];
    }

    public int getSuccessfulBombs(Side player)
    {
        return successfulBombs[player.getIndex()];
    }

    public int getSunkenShips(Side player)
    {
        return sunkenShips[player.getIndex()];
    }

    public String getGameMessage()
    {
        return gameMessage;
    }
}