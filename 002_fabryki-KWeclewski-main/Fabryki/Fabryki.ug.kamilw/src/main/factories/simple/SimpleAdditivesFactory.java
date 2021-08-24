package factories.simple;

import model.Additives.IAdditive;
import model.Additives.Milk;
import model.Additives.Sweetener;
import model.Additives.Whiskey;

public class SimpleAdditivesFactory {
    private static SimpleAdditivesFactory instance;

    private SimpleAdditivesFactory() {}

    public static SimpleAdditivesFactory getInstance() {
        if (instance == null) {
            synchronized (SimpleAdditivesFactory.class) {
                if (instance == null) {
                    instance = new SimpleAdditivesFactory();
                }
            }
        }
        return instance;
    }

    public IAdditive getAdditive(String name) {
        switch (name.toLowerCase()) {
            case "milk":
                return new Milk();
            case "whiskey":
                return new Whiskey();
            case "sweetener":
                return new Sweetener();
            default:
                throw new IllegalStateException(name + " <- there is non such additive.");
        }
    }
}
