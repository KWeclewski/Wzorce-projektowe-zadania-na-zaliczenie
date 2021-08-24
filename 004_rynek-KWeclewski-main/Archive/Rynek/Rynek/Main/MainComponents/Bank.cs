using Rynek.Main.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace Rynek.Main.MainComponents
{
    class Bank : IMyObserver, IMySubject
    {
        private double inflation;
        private List<Buyer> buyers;
        private List<Seller> sellers;

        public double Inflation { get => inflation; set => inflation = value; }

        public void Attach(IMyObserver observer)
        {
            if(observer.GetType() == typeof(Bank))
            {

            }
            if (!entities.Contains(observer))
            {
                entities.Add(observer);
            }
        }

        public void Detach(IMyObserver observer)
        {
            if (entities.Contains(observer))
            {
                entities.Remove(observer);
            }
        }

        public void Notify()
        {
            foreach(IMyObserver entity in entities)
            {
                entity.Update(Inflation);
            }
        }

        public void Update(double ceny)
        {
            //ceny
        }
    }
}
