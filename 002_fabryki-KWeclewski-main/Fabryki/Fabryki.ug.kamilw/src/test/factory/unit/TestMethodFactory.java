package factory.unit;

import factories.method.CoffeeFactory;
import factories.method.TeaFactory;
import model.Beverage.IBeverage;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class TestMethodFactory {
    @Test
    public void createCoffees() {
        CoffeeFactory coffeeFactory = CoffeeFactory.getInstance();
        IBeverage blackcoffee = coffeeFactory.getBeverage("blackcoffee");
        IBeverage irishcoffee = coffeeFactory.getBeverage("irishcoffee");
        IBeverage doppiocoffee = coffeeFactory.getBeverage("doppiocoffee");

        assertThat(blackcoffee, instanceOf(IBeverage.class));
        assertThat(irishcoffee, instanceOf(IBeverage.class));
        assertThat(doppiocoffee, instanceOf(IBeverage.class));
        assertEquals("Blackcoffee", blackcoffee.getName());
        assertEquals("Irishcoffee", irishcoffee.getName());
        assertEquals("Doppiocoffee", doppiocoffee.getName());
    }

    @Test
    public void creteTeas(){
        TeaFactory teaFactory = TeaFactory.getInstance();
        IBeverage whitetea = teaFactory.getBeverage("whitetea");
        IBeverage greentea = teaFactory.getBeverage("greentea");
        IBeverage englishtea = teaFactory.getBeverage("englishtea");

        assertThat(whitetea, instanceOf(IBeverage.class));
        assertThat(greentea, instanceOf(IBeverage.class));
        assertThat(englishtea, instanceOf(IBeverage.class));
        assertEquals("Whitetea",whitetea.getName());
        assertEquals("Greentea",greentea.getName());
        assertEquals("Englishtea",englishtea.getName());
    }

    @Test(expected = IllegalStateException.class)
    public void tryToCreateTeaFromCoffeeFactory(){
        CoffeeFactory coffeeFactory = CoffeeFactory.getInstance();
        coffeeFactory.getBeverage("whitetea");
    }

    @Test(expected = IllegalStateException.class)
    public void tryToCreateCoffeeFromTeaFactory(){
        TeaFactory teaFactory = TeaFactory.getInstance();
        teaFactory.getBeverage("irishcoffee");
    }
}
