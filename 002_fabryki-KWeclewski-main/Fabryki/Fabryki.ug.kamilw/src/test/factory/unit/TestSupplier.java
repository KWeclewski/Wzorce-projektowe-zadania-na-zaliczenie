package factory.unit;

import factories.register.ReflectionSizeFactory;
import factories.register.SupplierSizeFactory;
import model.Size.ISize;
import model.Size.Mega;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestSupplier {
    @Test(expected = IllegalStateException.class)
    public void getNotExistingShape(){
        SupplierSizeFactory.getSize("overloaded");
    }

    @Test(expected = IllegalStateException.class)
    public void tryToAddNewSize(){
        SupplierSizeFactory.getSize("Mega");

        SupplierSizeFactory.registerSupplier("Mega", Mega::new);

        ISize mega = SupplierSizeFactory.getSize("mega");
        assertThat(mega, instanceOf(Mega.class));
        assertEquals("Rectangle",mega.getSize());
    }

    @Test
    public void getSizes(){
        ISize small = ReflectionSizeFactory.getSize("small");
        ISize medium = ReflectionSizeFactory.getSize("medium");
        ISize large = ReflectionSizeFactory.getSize("large");

        assertEquals("Small",small.getSize());
        assertEquals("Medium",medium.getSize());
        assertEquals("Large",large.getSize());
    }
}
