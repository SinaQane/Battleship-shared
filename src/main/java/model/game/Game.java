package model.game;

import model.Board;
import model.Ship;
import model.User;
import model.cell.Cell;
import model.cell.CellStatus;

import java.util.LinkedList;
import java.util.List;

public class Game
{
    private final User[] players = new User[2];
    private final Board[] boards = new Board[2];
    private String gameMessage;
    private Side side;

    private int result = -1; // -1 while game is running, 0 if PLAYER_ONE won, 1 if PLAYER_TWO won

    public Game(User playerOne, User playerTwo)
    {
        players[0] = playerOne;
        players[1] = playerTwo;
        boards [0] = new Board();
        boards [1] = new Board();
        side = Side.PLAYER_ONE;
    }

    public void setGameMessage(String gameMessage)
    {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage()
    {
        return gameMessage;
    }

    public User getPlayer(Side player)
    {
        return players[player.getIndex()];
    }

    public Board getBoard(Side player)
    {
        return boards[player.getIndex()];
    }

    // Gameplay functions

    public void nextTurn()
    {
        side = side.getRival();
    }

    public void dropBomb(Side player, int x, int y)
    {
        boards[player.getRival().getIndex()].getBoard()[x][y].setBombed(true);
        nextTurn();
    }

    public void checkForEndGame()
    {
        boolean[] endGame = new boolean[]{true, true};
        for (int p = 0; p < 2; p++)
        {
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    if (boards[p].getCell(i, j).getStatus().equals(CellStatus.SHIP))
                    {
                        endGame[p] = false;
                    }
                }
            }
            if (endGame[p])
            {
                result = p;
            }
        }
    }

    public int getResult()
    {
        checkForEndGame();
        return result;
    }

    // GameList functions

    public int getDroppedBombs(Side player)
    {
        Cell[][] board = boards[player.getRival().getIndex()].getBoard();
        int cnt = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (board[i][j].getStatus().equals(CellStatus.BOMBED) || board[i][j].getStatus().equals(CellStatus.DESTROYED))
                {
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public int getSuccessfulBombs(Side player)
    {
        Cell[][] board = boards[player.getRival().getIndex()].getBoard();
        int cnt = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (board[i][j].getStatus().equals(CellStatus.DESTROYED))
                {
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public int getSunkenShips(Side player)
    {
        Cell[][] board = boards[player.getRival().getIndex()].getBoard();
        List<Ship> sunkenShips = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (board[i][j].getShip() != null)
                {
                    Ship ship = board[i][j].getShip();
                    if (ship.isDestroyed() && !sunkenShips.contains(ship))
                    {
                        sunkenShips.add(ship);
                    }
                }
            }
        }
        return sunkenShips.size();
    }
}