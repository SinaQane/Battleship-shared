package event.events.menu;

import event.Event;
import event.EventVisitor;
import model.game.Game;
import response.Response;

public class ViewGameEvent extends Event
{
    Game game;

    public ViewGameEvent(Game game)
    {
        this.game = game;
    }

    @Override
    public Response visit(EventVisitor eventVisitor)
    {
        return eventVisitor.viewGame(game);
    }
}
