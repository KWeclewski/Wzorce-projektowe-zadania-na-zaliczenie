using Rynek.Main.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace Rynek.Main.MainComponents
{
    class Seller : IMySubject, IMyObserver
    {
        private double productionCost;
        private double onStock;
        private double margin;

        private List<IMyObserver> banks;
        private double inflation;

        public double ProductionCost { get => productionCost; set => productionCost = value; }
        public double OnStock { get => onStock; set => onStock = value; }
        public double Margin { get => margin; set => margin = value; }

        public void Attach(IMyObserver observer)
        {
            if (!banks.Contains(observer))
            {
                banks.Add(observer);
            }
        }

        public void Detach(IMyObserver observer)
        {
            if (banks.Contains(observer))
            {
                banks.Remove(observer);
            }
        }

        public void Notify()
        {
            foreach(IMyObserver bank in banks)
            {
                //ceny
            }
        }

        public void Update(double inflation)
        {
            this.inflation = inflation;
        }
    }
}
