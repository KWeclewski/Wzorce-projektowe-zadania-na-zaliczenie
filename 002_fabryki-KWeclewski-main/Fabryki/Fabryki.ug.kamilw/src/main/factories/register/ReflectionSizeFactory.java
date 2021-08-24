package factories.register;

import model.Size.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectionSizeFactory {
    private static final Map<String, Class<? extends ISize>> sizes = new HashMap<>();
    static {
        sizes.put("small", Small.class);
        sizes.put("medium", Medium.class);
        sizes.put("large", Large.class);
        sizes.put("mega", Mega.class);
    }
    private ReflectionSizeFactory(){}

    public static void registerSize(String name, Class<? extends ISize> _class){
        sizes.put(name.toLowerCase(),_class);
    }
    public static ISize getSize(String name) {
        if (!sizes.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " we don't have this size in menu");
        }
        Class<? extends ISize> _class = sizes.get(name);
        try {
            Constructor constructor = _class.getDeclaredConstructor();
            return (ISize) constructor.newInstance();
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
