using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.SimpleFactory
{
    class CafeFactorySimple
    {
        public Product MakeOrder(Product product)
        {
            string type = product.GetType().Name.ToString();
            switch (type)
            {
                case "TeaGreen":
                    return new TeaGreen();
                case "TeaWhite":
                    return new TeaWhite();
                case "TeaBlack":
                    return new TeaBlack();
                case "TeaRaspberry":
                    return new TeaRaspberry();
                case "TeaOrange":
                    return new TeaOrange();
                case "CoffeeEspresso":
                    return new CoffeeEspresso();
                case "CoffeeAmericano":
                    return new CoffeeAmericano();
                case "CoffeeFlatWhite":
                    return new CoffeeFlatWhite();
                case "CoffeeBlack":
                    return new CoffeeBlack();
                case "CoffeeLatte":
                    return new CoffeeLatte();
                case "DrinkMohito":
                    return new DrinkMohito();
                case "DrinkBloodyMarry":
                    return new DrinkBloodyMarry();
                case "DrinkSexOnTheBeach":
                    return new DrinkSexOnTheBeach();
                case "DrinkMadDog":
                    return new DrinkMadDog();
                case "DrinkUboot":
                    return new DrinkUboot();
            }
            return null;
        }
    }
}
