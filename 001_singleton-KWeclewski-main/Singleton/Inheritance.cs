using System;
using System.Collections.Generic;
using System.Text;

namespace Singleton
{
    public abstract class ParentRight<T> where T: class
    {
        private static readonly Lazy<T> instance = new Lazy<T>(() =>
        CreateInstanceOfT());

        private static T CreateInstanceOfT()
        {
            return Activator.CreateInstance(typeof(T), true) as T;
        }

        public static T GetInstance { get { return instance.Value; } }
    }

    public class ChildRightOne : ParentRight<ChildRightOne>
    {
        private ChildRightOne() { }
    }

    public class ChildRightTwo : ParentRight<ChildRightTwo>
    {
        private ChildRightTwo() { }
    }
}
