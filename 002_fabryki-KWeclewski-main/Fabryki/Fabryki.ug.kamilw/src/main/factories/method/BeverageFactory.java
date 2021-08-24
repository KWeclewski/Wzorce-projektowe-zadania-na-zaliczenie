package factories.method;

import model.Beverage.IBeverage;

public abstract class BeverageFactory {
    public abstract IBeverage getBeverage(String name);
}
