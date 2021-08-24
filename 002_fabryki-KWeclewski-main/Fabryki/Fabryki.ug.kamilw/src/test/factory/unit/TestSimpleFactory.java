package factory.unit;

import factories.simple.SimpleAdditivesFactory;
import model.Additives.IAdditive;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSimpleFactory {
    @Test
    public void tryToCreateAdditive(){
        SimpleAdditivesFactory simpleAdditivesFactory = SimpleAdditivesFactory.getInstance();
        IAdditive milk = simpleAdditivesFactory.getAdditive("milk");
        IAdditive whiskey = simpleAdditivesFactory.getAdditive("whiskey");
        IAdditive sweetener = simpleAdditivesFactory.getAdditive("sweetener");

        assertEquals("Milk",milk.getAdditive());
        assertEquals("Whiskey",whiskey.getAdditive());
        assertEquals("Sweetener",sweetener.getAdditive());
    }

    @Test(expected = IllegalStateException.class)
    public void tryToCreateOtherNonExistingAdditive(){
        SimpleAdditivesFactory simpleAdditivesFactory = SimpleAdditivesFactory.getInstance();
        simpleAdditivesFactory.getAdditive("jajka");
    }
}
