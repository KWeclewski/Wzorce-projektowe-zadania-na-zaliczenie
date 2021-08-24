using ObjectPool.Source.Products;
using System;
using System.Collections.Generic;
using System.Text;

namespace ObjectPool.Source.Builders
{
    public interface ICoffeeBuilder
    {
        void ResetCoffeeMachine();
        void AddBase(double b);
        void AddSugar(double s);
        void AddMilk(double m);
        void AddAdditives(Additives a);
    }
}
