using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.FactoryWithRegistration
{
    public class FactoryWithRegistration
    {
        public static FactoryWithRegistration Instance { get { return _instance; } }

        private static FactoryWithRegistration _instance = new FactoryWithRegistration();
        private FactoryWithRegistration() { }

        static Dictionary<string, Product> _registeredType = new Dictionary<string, Product>();

        public void Register(string id, Product product)
        {
            _registeredType.Add(id, product);
        }

        public Product Create(string id, params object[] parameters)
        {
            Type type = typeof(Product);
            return (Product) _registeredType.GetValueOrDefault(id).CreateInstance(typeof(Product), parameters);
            
        }
    }
}
