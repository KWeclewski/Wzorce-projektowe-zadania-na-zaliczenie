using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.AbstractFactory.AdditivesFactory
{
    class SweetenedAdditivesFactory : IAdditivesFactory
    {
        public string additives { get; set; }

        public SweetenedAdditivesFactory()
        {
            additives = "sugar";
        }
    }
}
