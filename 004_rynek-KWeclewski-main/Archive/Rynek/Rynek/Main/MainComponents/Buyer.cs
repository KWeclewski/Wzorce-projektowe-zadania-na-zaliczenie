using Rynek.Main.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace Rynek.Main.MainComponents
{
    class Buyer : IMyObserver
    {
        private double money;
        private double needs;

        private double inflation;

        public double Money { get => money; set => money = value; }
        public double Needs { get => needs; set => needs = value; }

        public void Update(double inflation)
        {
            this.inflation = inflation;
        }
    }
}
