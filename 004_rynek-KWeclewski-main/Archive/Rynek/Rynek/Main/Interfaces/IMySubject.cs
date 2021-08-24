using System;
using System.Collections.Generic;
using System.Text;

namespace Rynek.Main.Interfaces
{
    interface IMySubject
    {
        void Attach(IMyObserver observer);
        void Detach(IMyObserver observer);
        void Notify();
    }
}
