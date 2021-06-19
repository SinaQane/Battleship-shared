package model;

public class User
{
    private final String username;
    private final String password;
    private boolean online;
    private int score;
    private int wins;
    private int loses;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        score = wins = loses = 0;
        online =  true;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isOnline()
    {
        return online;
    }

    public int getScore()
    {
        return score;
    }

    public int getWins()
    {
        return wins;
    }

    public int getLoses()
    {
        return loses;
    }

    public void Login()
    {
        online = true;
    }

    public void logout()
    {
        online = false;
    }

    public void finishedGame(String result)
    {
        if (result.equals("win"))
        {
            wins++;
            score++;
        }
        else
        {
            loses++;
            score--;
        }
    }
}
