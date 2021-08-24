using Fabryki.Domain.Abstraction;
using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.Domain.Models
{
    class TeaGreen : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Green Tea";
            this.productType = ProductType.Tea;
        }
    }
    class TeaWhite : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "White Tea";
            this.productType = ProductType.Tea;
        }
    }
    class TeaBlack : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Black Tea";
            this.productType = ProductType.Tea;
        }
    }
    class TeaRaspberry : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Raspberry Tea";
            this.productType = ProductType.Tea;
        }
    }
    class TeaOrange : IProduct
    {
        public string name { get; set; }
        public ProductType productType { get; set; }

        public void CreateProduct()
        {
            this.name = "Orange Tea";
            this.productType = ProductType.Tea;
        }
    }
}
