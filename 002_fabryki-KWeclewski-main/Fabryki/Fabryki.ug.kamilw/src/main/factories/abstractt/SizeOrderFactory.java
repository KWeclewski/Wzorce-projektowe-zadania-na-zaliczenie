package factories.abstractt;

import model.Beverage.EnglishTea;
import model.Beverage.IBeverage;
import model.Size.ISize;
import model.Size.Medium;

public class SizeOrderFactory extends AbstracttOrderFactory{
    private static SizeOrderFactory instance;

    private SizeOrderFactory(){}

    public static SizeOrderFactory getInstance() {
        if (instance == null) {
            synchronized (SizeOrderFactory.class){
                if (instance == null) {
                    instance = new SizeOrderFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public ISize getSize() {
        return new Medium();
    }

    @Override
    public IBeverage getBeverage() {
        return new EnglishTea();
    }
}
