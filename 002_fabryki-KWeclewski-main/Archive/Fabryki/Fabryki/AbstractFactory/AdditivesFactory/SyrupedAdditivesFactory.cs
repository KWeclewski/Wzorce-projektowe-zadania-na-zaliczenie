using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory.AdditivesFactory
{
    class SyrupedAdditivesFactory : IAdditivesFactory
    {
        public string additives { get; set; }

        public SyrupedAdditivesFactory()
        {
            additives = "syrup";
        }
    }
}
