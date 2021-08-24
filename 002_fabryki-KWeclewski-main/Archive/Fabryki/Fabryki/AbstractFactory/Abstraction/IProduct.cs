using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;


namespace Fabryki.AbstractFactory.Abstraction
{
    interface IProduct
    {
        string name { get; set; }
        ProductType productType { get; set; }
        void CreateProduct();
    }
}
