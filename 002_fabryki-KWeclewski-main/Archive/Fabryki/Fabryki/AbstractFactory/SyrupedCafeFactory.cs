using System;
using System.Collections.Generic;
using System.Text;
using Fabryki.AbstractFactory.Abstraction;
using Fabryki.AbstractFactory.AdditivesFactory;
using Fabryki.AbstractFactory.Models;

namespace Fabryki.AbstractFactory
{
    class SyrupedCafeFactory : ICafeFactoryAbstract
    {
        public IProduct MakeOrder(string item)
        {
            IAdditivesFactory additivesFactory = new SyrupedAdditivesFactory();
            string type = item.GetType().Name.ToString();
            IProduct product = null;
            switch (type)
            {
                case "TeaGreen":
                    product = new TeaGreen(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "TeaWhite":
                    product = new TeaWhite(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "TeaBlack":
                    product = new TeaBlack(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "TeaRaspberry":
                    product = new TeaRaspberry(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "TeaOrange":
                    product = new TeaOrange(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "CoffeeEspresso":
                    product = new CoffeeEspresso(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "CoffeeAmericano":
                    product = new CoffeeAmericano(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "CoffeeFlatWhite":
                    product = new CoffeeFlatWhite(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "CoffeeBlack":
                    product = new CoffeeBlack(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "CoffeeLatte":
                    product = new CoffeeLatte(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "DrinkMohito":
                    product = new DrinkMohito(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "DrinkBloodyMarry":
                    product = new DrinkBloodyMarry(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "DrinkSexOnTheBeach":
                    product = new DrinkSexOnTheBeach(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "DrinkMadDog":
                    product = new DrinkMadDog(additivesFactory);
                    product.CreateProduct();
                    return product;
                case "DrinkUboot":
                    product = new DrinkUboot(additivesFactory);
                    product.CreateProduct();
                    return product;
            }
            return product;
        }
    }
}
