package factories.abstractt;

import model.Beverage.IBeverage;
import model.Beverage.IrishCoffee;
import model.Size.ISize;
import model.Size.Mega;

public class BeverageOrderFactory extends AbstracttOrderFactory {
    private static BeverageOrderFactory instance;

    private BeverageOrderFactory(){}

    public static BeverageOrderFactory getInstance() {
        if (instance == null) {
            synchronized (BeverageOrderFactory.class){
                if (instance == null) {
                    instance = new BeverageOrderFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public ISize getSize() {
        return new Mega();
    }

    @Override
    public IBeverage getBeverage() {
        return new IrishCoffee();
    }
}
