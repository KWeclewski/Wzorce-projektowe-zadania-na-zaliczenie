using System;
using System.Collections.Generic;
using System.Text;

namespace Singleton
{
    public class ThreadSafeStatic
    {
        private ThreadSafeStatic() { }
        private static ThreadSafeStatic instance;
        private static readonly object _lock = new object();

        public static ThreadSafeStatic GetInstance()
        {
            if(instance == null)
            {
                lock (_lock)
                {
                    if(instance == null)
                    {
                        instance = new ThreadSafeStatic();
                    }
                }
            }
            return instance;
        }
    }
}
