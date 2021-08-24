using Fabryki.Domain.Enumerators;

namespace Fabryki.SimpleFactory
{
    public abstract class Product
    {
        protected Product()
        {
            CreateProduct();
        }

        public string name { get; set; }
        ProductType productType { get; set; }
        public void CreateProduct()
        {
            name = "none";
            productType = ProductType.None;
        }
    }
}