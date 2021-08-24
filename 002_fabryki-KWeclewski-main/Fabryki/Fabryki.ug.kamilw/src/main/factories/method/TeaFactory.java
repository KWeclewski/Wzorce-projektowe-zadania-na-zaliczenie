package factories.method;

import model.Beverage.*;

public class TeaFactory extends BeverageFactory{
    private static TeaFactory instance;

    private TeaFactory() {}

    public static TeaFactory getInstance() {
        if (instance == null) {
            synchronized (TeaFactory.class){
                if (instance == null) {
                    instance = new TeaFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public IBeverage getBeverage(String name) {
        switch (name.toLowerCase()) {
            case "blacktea":
                return new BlackTea();
            case "englishtea":
                return new EnglishTea();
            case "greentea":
                return new GreenTea();
            case "whitetea":
                return new WhiteTea();
            default:
                throw new IllegalStateException(name + " sorry we don't have this tea in our menu");
        }
    }
}
