package event;

import response.Response;

public abstract class Event
{
    public abstract Response visit(EventVisitor eventVisitor);
}
