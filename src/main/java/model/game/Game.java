package model.game;

import model.Board;
import model.Ship;
import model.User;
import model.cell.Cell;
import model.cell.CellStatus;

import java.util.concurrent.atomic.AtomicInteger;

// Integer "result" is -1 while game is running, 0 if PLAYER_ONE is the winner & 1 if PLAYER_TWO is the winner
public class Game
{
    private final User[] players = new User[2];
    private final Board[] boards = new Board[2];
    private String gameMessage;
    private boolean running;
    private Side side;
    private int moves;
    private final AtomicInteger time;

    private int result = -1;

    public Game(User playerOne, User playerTwo)
    {
        time = new AtomicInteger(50);
        players[0] = playerOne;
        players[1] = playerTwo;
        boards [0] = new Board();
        boards [1] = new Board();
        side = Side.PLAYER_ONE;
        running = true;
        moves = 0;
        gameMessage = players[0].getUsername() + "'s move";
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

    public void setBoard(int index, Board board)
    {
        boards[index] = board;
    }

    public synchronized void updateTimer()
    {
        time.decrementAndGet();
    }

    public synchronized void resetTimer()
    {
        time.set(50);
    }

    public synchronized int getTime()
    {
        return time.get();
    }

    public boolean isRunning()
    {
        return running;
    }

    public int getMoves()
    {
        return moves;
    }

    public int getSide()
    {
        if (side.equals(Side.PLAYER_ONE))
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    // Gameplay functions

    public void nextTurn(boolean passTurn)
    {
        if (passTurn)
        {
            side = side.getRival();
        }
        moves++;
        if (side.equals(Side.PLAYER_ONE))
        {
            setGameMessage(players[0].getUsername() + "'s move");
        }
        else
        {
            setGameMessage(players[1].getUsername() + "'s move");
        }
    }

    public boolean dropBomb(Side player, int x, int y) // returns true if the bombing is valid and done
    {
        if (player.equals(this.side))
        {
            if (0<=x && x<=9 && 0<=y && y<=9)
            {
                Cell selectedCell = boards[player.getRival().getIndex()].getBoard()[x][y];
                if (!selectedCell.isBombed())
                {
                    selectedCell.setBombed(true);
                    nextTurn(!(selectedCell.isBombed() && selectedCell.getShip()));
                    return true;
                }
            }
        }
        return false;
    }

    public void explosion(Side player, int x, int y)
    {
        if (player.equals(this.side))
        {
            if (0<=x && x<=9 && 0<=y && y<=9)
            {
                Cell selectedCell = boards[player.getRival().getIndex()].getBoard()[x][y];
                if (!selectedCell.isBombed())
                {
                    selectedCell.setBombed(true);
                }
            }
        }
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
                result = (p + 1) % 2;
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
        setGameMessage(players[getResult()].getUsername() + " won!");
        players[getResult()].finishedGame("win");
        players[(getResult() + 1) % 2].finishedGame("lose");
        running = false;
    }

    public void resign(Side side)
    {
        setGameMessage(players[side.getRival().getIndex()].getUsername() + " won!");
        players[side.getRival().getIndex()].finishedGame("win");
        players[side.getIndex()].finishedGame("lose");
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
            if (isShipDestroyed(player, ship))
            {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isShipDestroyed(Side player, Ship ship)
    {
        for (Integer[] coordinate : ship.getShip())
        {
            if (!boards[player.getIndex()].getBoard()[coordinate[0]][coordinate[1]].isBombed())
            {
                return false;
            }
        }
        return true;
    }
}