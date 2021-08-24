using Fabryki.Domain.Abstraction;
using Fabryki.Domain.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.FactoryMethodFactory
{
    class CafeFactoryMethodFactory
    {
        public IProduct MakeOrder(IProduct product)
        {
            product.CreateProduct();
            return product;
        }
    }
}
