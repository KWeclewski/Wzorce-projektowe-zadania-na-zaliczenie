using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.FactoryWithRegistration
{
    class SingleProduct : Product
    {
		FactoryWithRegistration fwr = new FactoryWithRegistration();

        fwr.Register("ID1", new SingleProduct());
	}
    public SingleProduct CreateProduct()
    {
        return new SingleProduct();
    }
    //...
}
}
