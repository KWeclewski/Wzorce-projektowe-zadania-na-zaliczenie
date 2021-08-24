using Fabryki.AbstractFactory.AdditivesFactory;
using Fabryki.AbstractFactory.Abstraction;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory.Models
{
    class DrinkMohito : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public DrinkMohito(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Mohito";
            this.productType = ProductType.Drink;
            this.additives = additivesFactory.additives;
        }
    }
    class DrinkBloodyMarry : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public DrinkBloodyMarry(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Bloody Marry";
            this.productType = ProductType.Drink;
            this.additives = additivesFactory.additives;
        }
    }
    class DrinkSexOnTheBeach : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public DrinkSexOnTheBeach(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Sex on the beach";
            this.productType = ProductType.Drink;
            this.additives = additivesFactory.additives;
        }
    }
    class DrinkMadDog : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public DrinkMadDog(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Mad dog";
            this.productType = ProductType.Drink;
            this.additives = additivesFactory.additives;
        }
    }
    class DrinkUboot : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public DrinkUboot(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "U-boot";
            this.productType = ProductType.Drink;
            this.additives = additivesFactory.additives;
        }
    }
}
