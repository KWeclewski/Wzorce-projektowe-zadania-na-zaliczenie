using Microsoft.VisualStudio.TestTools.UnitTesting;
using Singleton;
using System.Threading;

namespace SingletonTests
{
    [TestClass]
    public class InheritanceTests
    {
        [TestMethod]
        public void InstanceIsTypeOfChild()
        {
            var testowy1 = ChildRightOne.GetInstance;
            var testowy2 = ChildRightTwo.GetInstance;
            var testowy3 = ChildRightOne.GetInstance;
            var testowy4 = ChildRightTwo.GetInstance;

            var thread1 = new Thread(() =>
            {
                testowy1 = ChildRightOne.GetInstance;
            });
            var thread2 = new Thread(() =>
            {
                testowy2 = ChildRightTwo.GetInstance;
            });
            var thread3 = new Thread(() =>
            {
                testowy3 = ChildRightOne.GetInstance;
            });
            var thread4 = new Thread(() =>
            {
                testowy4 = ChildRightTwo.GetInstance;
            });

            thread1.Start();
            thread2.Start();
            thread3.Start();
            thread4.Start();

            thread1.Join();
            thread2.Join();
            thread3.Join();
            thread4.Join();

            Assert.AreSame(testowy1.GetType(), typeof(ChildRightOne));
            Assert.AreSame(testowy3.GetType(), typeof(ChildRightOne));
            Assert.AreSame(testowy2.GetType(), typeof(ChildRightTwo));
            Assert.AreSame(testowy4.GetType(), typeof(ChildRightTwo));
            Assert.AreNotSame(testowy1.GetType(), testowy2.GetType());
            Assert.AreNotSame(testowy3.GetType(), testowy4.GetType());
            Assert.AreNotSame(testowy3.GetType(), testowy2.GetType());
            Assert.AreNotSame(testowy1.GetType(), testowy4.GetType());
        }
    }
}
