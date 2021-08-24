using Fabryki.AbstractFactory.Abstraction;
using Fabryki.Domain.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory
{
    interface ICafeFactoryAbstract
    {
        IProduct MakeOrder(string item);
    }
}
