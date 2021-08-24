using Fabryki.AbstractFactory.Abstraction;
using Fabryki.AbstractFactory.AdditivesFactory;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory.Models
{
    class CoffeeEspresso : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public CoffeeEspresso(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Espresso";
            this.productType = ProductType.Coffee;
            this.additives = additivesFactory.additives;
        }
    }

    class CoffeeAmericano : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public CoffeeAmericano(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Americano";
            this.productType = ProductType.Coffee;
            this.additives = additivesFactory.additives;
        }
    }

    class CoffeeFlatWhite : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public CoffeeFlatWhite(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Flat White";
            this.productType = ProductType.Coffee;
            this.additives = additivesFactory.additives;
        }
    }

    class CoffeeBlack : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public CoffeeBlack(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Black";
            this.productType = ProductType.Coffee;
            this.additives = additivesFactory.additives;
        }
    }

    class CoffeeLatte : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public CoffeeLatte(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Latte";
            this.productType = ProductType.Coffee;
            this.additives = additivesFactory.additives;
        }
    }
}
