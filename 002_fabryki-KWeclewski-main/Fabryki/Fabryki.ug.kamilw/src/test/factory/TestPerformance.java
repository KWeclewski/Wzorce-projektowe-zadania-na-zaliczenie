package factory;


import com.sun.glass.ui.Size;
import factories.abstractt.AbstracttOrderFactory;
import factories.abstractt.BeverageOrderFactory;
import factories.abstractt.SizeOrderFactory;
import factories.register.ReflectionSizeFactory;
import factories.register.SupplierSizeFactory;
import factories.simple.SimpleAdditivesFactory;

@State(Scope.Benchmark)
public class TestPerformance {

    @Param({"7897891"})
    int loops;

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void TestSimpleFactory() {
        SimpleAdditivesFactory simpleAdditivesFactory = SimpleAdditivesFactory.getInstance();
        for (int i = 0; i < loops; i++){
            simpleAdditivesFactory.getAdditive("whiskey");
            simpleAdditivesFactory.getAdditive("milk");
            simpleAdditivesFactory.getAdditive("sweetener");
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void TestAbstractFactory() {
        BeverageOrderFactory beverageOrderFactory = BeverageOrderFactory.getInstance();
        SizeOrderFactory sizeOrderFactory = SizeOrderFactory.getInstance();
        for (int i = 0; i < loops; i++){
            beverageOrderFactory.getBeverage();
            beverageOrderFactory.getSize();
            sizeOrderFactory.getSize();
            sizeOrderFactory.getBeverage();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void TestReflection() {
        for (int i = 0; i < loops; i++){
            ReflectionSizeFactory.getSize("small");
            ReflectionSizeFactory.getSize("medium");
            ReflectionSizeFactory.getSize("large");
            ReflectionSizeFactory.getSize("mega");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void TestSupplierFactory(){
        for (int i = 0; i < loops; i++){
            SupplierSizeFactory.getSize("small");
            SupplierSizeFactory.getSize("medium");
            SupplierSizeFactory.getSize("large");
        }
    }
}
