package factory.unit;

import factories.abstractt.BeverageOrderFactory;
import factories.abstractt.SizeOrderFactory;
import model.Beverage.IBeverage;
import model.Size.ISize;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestAbstractFactory {
    @Test
    public void getBeverageAndSizeAndAllFactories() {
        //beverageOrderFactory test na poprawnosc danych
        BeverageOrderFactory beverageForTest = BeverageOrderFactory.getInstance();
        IBeverage BeverageData = beverageForTest.getBeverage();
        ISize SizeData = beverageForTest.getSize();

        String resultBeverageFromBeverageFactory = "Irishcoffee";
        String resultSizeFromBeverageFactory = "Mega";

        assertEquals(resultSizeFromBeverageFactory, SizeData.getSize());
        assertEquals(resultBeverageFromBeverageFactory, BeverageData.getName());

        //sizeorderfactory test na poprawnosc danych
        SizeOrderFactory sizeForTest = SizeOrderFactory.getInstance();
        ISize SizeDataSecond = sizeForTest.getSize();
        IBeverage BeverageDataSecond = sizeForTest.getBeverage();

        String resultSizeFromSizeFactory = "Medium";
        String resultBeverageFromSizeFactory = "Englishtea";

        assertEquals(resultBeverageFromSizeFactory, BeverageDataSecond.getName());
        assertEquals(resultSizeFromSizeFactory, SizeDataSecond.getSize());
    }
}
