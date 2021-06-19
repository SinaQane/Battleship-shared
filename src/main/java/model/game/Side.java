package model.game;

public enum Side
{
    PLAYER_ONE
    {
        @Override
        public Side getRival()
        {
            return PLAYER_TWO;
        }

        @Override
        public int getIndex()
        {
            return 0;
        }

    },
    PLAYER_TWO
    {
        @Override
        public Side getRival()
        {
            return PLAYER_ONE;
        }

        @Override
        public int getIndex()
        {
            return 1;
        }
    };

    public abstract Side getRival();

    public abstract int getIndex();
}
