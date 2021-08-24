package factories.abstractt;

import model.Beverage.IBeverage;
import model.Size.ISize;

public abstract class AbstracttOrderFactory {
    public abstract IBeverage getBeverage();
    public abstract ISize getSize();
}
