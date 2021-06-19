package json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class Serializer<T> implements JsonSerializer<T> {

    @Override
    public JsonElement serialize(T src, Type type, JsonSerializationContext context)
    {
        JsonObject returnValue = new JsonObject();
        String className = src.getClass().getName();
        returnValue.addProperty(Constants.CLASSNAME, className);
        JsonElement element = context.serialize(src);
        returnValue.add(Constants.INSTANCE, element);
        return returnValue;
    }
}