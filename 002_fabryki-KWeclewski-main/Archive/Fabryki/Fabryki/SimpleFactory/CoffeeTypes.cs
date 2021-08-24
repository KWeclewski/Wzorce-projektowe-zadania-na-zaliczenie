using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.SimpleFactory
{
    class CoffeeEspresso : Product
    {
        public CoffeeEspresso()
        {
            this.CreateProduct();
        }
    }

    class CoffeeAmericano : Product
    {
        public CoffeeAmericano()
        {
            this.CreateProduct();
        }
    }

    class CoffeeFlatWhite : Product
    {
        public CoffeeFlatWhite()
        {
            this.CreateProduct();
        }
    }

    class CoffeeBlack : Product
    {
        public CoffeeBlack()
        {
            this.CreateProduct();
        }
    }

    class CoffeeLatte : Product
    {
        public CoffeeLatte()
        {
            this.CreateProduct();
        }
    }
}
