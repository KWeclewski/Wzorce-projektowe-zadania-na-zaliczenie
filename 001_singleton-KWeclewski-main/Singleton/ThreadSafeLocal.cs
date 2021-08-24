using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Singleton
{
    public class ThreadSafeLocal
    {
        private ThreadSafeLocal() { }
        private static ThreadLocal<ThreadSafeLocal> instance = 
            new ThreadLocal<ThreadSafeLocal>(() => new ThreadSafeLocal());

        public static ThreadSafeLocal GetInstance
        {
            get { return instance.Value; }
        }
        
    }
}
