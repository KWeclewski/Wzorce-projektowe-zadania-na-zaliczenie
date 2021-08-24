using System;
using System.Collections.Generic;
using System.Text;
using ObjectPool.Source.Products;

namespace ObjectPool.Source.Builders
{
    class MapleFlatwhiteCoffeeDrinkBuilder : ICoffeeBuilder
    {
        private Coffee coffee = new Coffee();

        public void AddAdditives(Additives a)
        {
            this.coffee.Additives = a;
        }

        public void AddBase(double b)
        {
            double temp = 1;
            for (int i = 0; i < 1000; i++)
                for (int j = 0; j < 1000; i++)
                    temp *= Math.Cos(b);
            this.coffee.CoffeeAmount = temp;
        }

        public void AddMilk(double m)
        {
            double temp = 1;
            for (int i = 0; i < 1000; i++)
                for (int j = 0; j < 1000; i++)
                    temp *= Math.Cos(m);
            this.coffee.MilkAmount = temp;
        }

        public void AddSugar(double s)
        {
            double temp = 1;
            for (int i = 0; i < 1000; i++)
                for (int j = 0; j < 1000; i++)
                    temp *= Math.Cos(s);
            this.coffee.SugarAmount = temp;
        }

        public void ResetCoffeeMachine()
        {
            this.coffee = new Coffee();
        }
    }
}
