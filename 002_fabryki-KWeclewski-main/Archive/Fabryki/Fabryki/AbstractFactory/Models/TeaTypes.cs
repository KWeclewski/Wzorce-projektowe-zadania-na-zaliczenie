using Fabryki.AbstractFactory.AdditivesFactory;
using Fabryki.AbstractFactory.Abstraction;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory.Models
{
    class TeaGreen : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public TeaGreen(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Green Tea";
            this.productType = ProductType.Tea;
            this.additives = additivesFactory.additives;
        }
    }
    class TeaWhite : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public TeaWhite(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "White Tea";
            this.productType = ProductType.Tea;
            this.additives = additivesFactory.additives;
        }
    }
    class TeaBlack : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public TeaBlack(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Black Tea";
            this.productType = ProductType.Tea;
            this.additives = additivesFactory.additives;
        }
    }
    class TeaRaspberry : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public TeaRaspberry(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Raspberry Tea";
            this.productType = ProductType.Tea;
            this.additives = additivesFactory.additives;
        }
    }
    class TeaOrange : IProduct
    {
        public IAdditivesFactory additivesFactory;

        public TeaOrange(IAdditivesFactory additivesFactory)
        {
            this.additivesFactory = additivesFactory;
        }

        public string additives { get; set; }
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Orange Tea";
            this.productType = ProductType.Tea;
            this.additives = additivesFactory.additives;
        }
    }
}
