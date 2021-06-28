package model.game;

import model.Board;
import model.Ship;
import model.User;
import model.cell.Cell;
import model.cell.CellStatus;

public class Game
{
    private final User[] players = new User[2];
    private final Board[] boards = new Board[2];
    private String gameMessage;
    private boolean running;
    private Side side;

    private int result = -1; // -1 while game is running, 0 if PLAYER_ONE won, 1 if PLAYER_TWO won

    public Game(User playerOne, User playerTwo)
    {
        players[0] = playerOne;
        players[1] = playerTwo;
        boards [0] = new Board();
        boards [1] = new Board();
        side = Side.PLAYER_ONE;
        running = true;
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

    public boolean isRunning()
    {
        return running;
    }

    // Gameplay functions

    public void nextTurn()
    {
        side = side.getRival();
    }

    public boolean dropBomb(Side player, int x, int y) // returns true if the bombing is valid
    {
        if (player.equals(this.side))
        {
            if (0<=x && x<=9 && 0<=y && y<=9)
            {
                if (!boards[player.getRival().getIndex()].getBoard()[x][y].isBombed())
                {
                    boards[player.getRival().getIndex()].getBoard()[x][y].setBombed(true);
                    nextTurn();
                    return true;
                }
            }
        }
        return false;
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

    public void endGame()
    {
        running = false;
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
        Board board = boards[player.getRival().getIndex()];
        int cnt = 0;
        for (Ship ship : board.getShips())
        {
            if (ship.isDestroyed())
            {
                cnt++;
            }
        }
        return cnt;
    }
}