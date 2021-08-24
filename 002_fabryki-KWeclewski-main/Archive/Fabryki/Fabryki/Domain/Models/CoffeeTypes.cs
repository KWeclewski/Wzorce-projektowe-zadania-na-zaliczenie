using Fabryki.Domain.Abstraction;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.Domain.Models
{
    class CoffeeEspresso : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Espresso";
            this.productType = ProductType.Coffee;
        }
    }

    class CoffeeAmericano : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Americano";
            this.productType = ProductType.Coffee;
        }
    }

    class CoffeeFlatWhite : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Flat White";
            this.productType = ProductType.Coffee;
        }
    }

    class CoffeeBlack : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Black";
            this.productType = ProductType.Coffee;
        }
    }

    class CoffeeLatte : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Latte";
            this.productType = ProductType.Coffee;
        }
    }
}
