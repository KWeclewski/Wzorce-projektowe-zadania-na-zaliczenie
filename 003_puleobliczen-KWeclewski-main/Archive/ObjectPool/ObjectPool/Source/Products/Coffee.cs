using System;
using System.Collections.Generic;
using System.Text;

namespace ObjectPool.Source.Products
{
    public class Coffee
    {
        private double coffeeAmount;
        private double sugarAmount;
        private double milkAmount;
        private Additives additives;

        public double CoffeeAmount { get => coffeeAmount; set => coffeeAmount = value; }
        public double SugarAmount { get => sugarAmount; set => sugarAmount = value; }
        public double MilkAmount { get => milkAmount; set => milkAmount = value; }
        public Additives Additives { get => additives; set => additives = value; }
    }
}
