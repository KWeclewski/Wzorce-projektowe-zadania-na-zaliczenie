using Fabryki.Domain.Abstraction;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.Domain.Models
{
    class DrinkMohito : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Mohito";
            this.productType = ProductType.Drink;
        }
    }
    class DrinkBloodyMarry : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Bloody Marry";
            this.productType = ProductType.Drink;
        }
    }
    class DrinkSexOnTheBeach : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Sex on the beach";
            this.productType = ProductType.Drink;
        }
    }
    class DrinkMadDog : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Mad dog";
            this.productType = ProductType.Drink;
        }
    }
    class DrinkUboot : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "U-boot";
            this.productType = ProductType.Drink;
        }
    }
}
