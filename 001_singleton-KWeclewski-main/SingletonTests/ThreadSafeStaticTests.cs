using Microsoft.VisualStudio.TestTools.UnitTesting;
using Singleton;
using System.Threading;

namespace SingletonTests
{
    [TestClass]
    public class ThreadSafeStaticTests
    {
        [TestMethod]
        public void StaticThreadSafety()
        {
            var testowy1 = ThreadSafeStatic.GetInstance();
            var testowy2 = ThreadSafeStatic.GetInstance();
            var testowy3 = ThreadSafeStatic.GetInstance();
            var testowy4 = ThreadSafeStatic.GetInstance();
            var testowy5 = ThreadSafeStatic.GetInstance();

            var thread1 = new Thread(() =>
            {
                testowy1 = ThreadSafeStatic.GetInstance();
            });
            var thread2 = new Thread(() =>
            {
                testowy2 = ThreadSafeStatic.GetInstance();
            });
            var thread3 = new Thread(() =>
            {
                testowy3 = ThreadSafeStatic.GetInstance();
            });
            var thread4 = new Thread(() =>
            {
                testowy4 = ThreadSafeStatic.GetInstance();
            });
            var thread5 = new Thread(() =>
            {
                testowy5 = ThreadSafeStatic.GetInstance();
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

            Assert.AreSame(testowy1, testowy2);
            Assert.AreSame(testowy3, testowy2);
            Assert.AreSame(testowy1, testowy3);
            Assert.AreSame(testowy2, testowy5);
            Assert.AreSame(testowy5, testowy4);
        }
    }
}
