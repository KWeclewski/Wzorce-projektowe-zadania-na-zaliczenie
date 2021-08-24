package factories.method;

import model.Beverage.*;

public class CoffeeFactory extends BeverageFactory{
    private static CoffeeFactory instance;

    private CoffeeFactory() {}

    public static CoffeeFactory getInstance() {
        if (instance == null) {
            synchronized (CoffeeFactory.class){
                if (instance == null) {
                    instance = new CoffeeFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public IBeverage getBeverage(String name) {
        switch (name.toLowerCase()) {
            case "blackcoffee":
                return new BlackCoffee();
            case "americanocoffee":
                return new AmericanoCoffee();
            case "doppiocoffee":
                return new DoppioCoffee();
            case "irishcoffee":
                return new IrishCoffee();
            default:
                throw new IllegalStateException(name + " sorry we don't have this coffee in our menu");
        }
    }
}
