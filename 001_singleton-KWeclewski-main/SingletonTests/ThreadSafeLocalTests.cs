using Microsoft.VisualStudio.TestTools.UnitTesting;
using Singleton;
using System.Threading;

namespace SingletonTests
{
    [TestClass]
    public class ThreadSafeLocalTests
    {
        [TestMethod]
        public void ThreadSafeLocalTest()
        {
            var testowy1 = ThreadSafeLocal.GetInstance;
            var testowy2 = ThreadSafeLocal.GetInstance;
            var testowy3 = ThreadSafeLocal.GetInstance;
            var testowy4 = ThreadSafeLocal.GetInstance;
            var testowy5 = ThreadSafeLocal.GetInstance;

            var thread1 = new Thread(() =>
            {
                testowy1 = ThreadSafeLocal.GetInstance;
            });
            var thread2 = new Thread(() =>
            {
                testowy2 = ThreadSafeLocal.GetInstance;
            });
            var thread3 = new Thread(() =>
            {
                testowy3 = ThreadSafeLocal.GetInstance;
            });
            var thread4 = new Thread(() =>
            {
                testowy4 = ThreadSafeLocal.GetInstance;
            });
            var thread5 = new Thread(() =>
            {
                testowy5 = ThreadSafeLocal.GetInstance;
            });

            thread1.Start();
            thread2.Start();
            thread3.Start();
            thread4.Start();
            thread5.Start();

            thread1.Join();
            thread2.Join();
            thread3.Join();
            thread4.Join();
            thread5.Join();

            Assert.AreNotSame(testowy1, testowy2);
            Assert.AreNotSame(testowy2, testowy3);
            Assert.AreNotSame(testowy3, testowy4);
            Assert.AreNotSame(testowy4, testowy5);
            Assert.AreNotSame(testowy5, testowy1);
        }
    }
}
