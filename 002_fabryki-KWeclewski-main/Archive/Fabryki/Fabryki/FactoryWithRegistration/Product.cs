using Fabryki.Domain.Enumerators;
using System;
using System.Collections.Generic;
using System.Text;


namespace Fabryki.FactoryWithRegistration
{
    public abstract class Product
    {
        public abstract Product CreateInstance();
    }
}
