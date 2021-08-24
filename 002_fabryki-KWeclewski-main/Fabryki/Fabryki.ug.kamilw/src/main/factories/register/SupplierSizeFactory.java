package factories.register;

import model.Size.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SupplierSizeFactory {
    private static final Map<String, Supplier<? extends ISize>> sizes = new HashMap<>();
    static {
        sizes.put("small", Small::new);
        sizes.put("medium", Medium::new);
        sizes.put("large", Large::new);
    }
    private SupplierSizeFactory(){}

    public static void registerSupplier(String name, Supplier<? extends ISize> supplier){
        sizes.put(name.toLowerCase(), supplier);
    }

    public static ISize getSize(String name){
        if (!sizes.containsKey(name.toLowerCase())){
            throw new IllegalStateException(name + " we don't have this size.");
        }
        return sizes.get(name).get();
    }
}
