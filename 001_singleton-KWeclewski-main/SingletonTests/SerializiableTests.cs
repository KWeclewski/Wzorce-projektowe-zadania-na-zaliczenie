using Microsoft.VisualStudio.TestTools.UnitTesting;
using Singleton;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace SingletonTests
{
    [TestClass]
    public class SerializableTests
    {
        [TestMethod]
        public void IsSameAfterSerialization()
        {
            var savedSingleton = SerializableSingleton.GetInstance;

            IFormatter formatter = new BinaryFormatter();

            using (Stream writeStream = new FileStream("singleton.bin",
                FileMode.Create,
                FileAccess.Write,
                FileShare.Write))
            {
                formatter.Serialize(writeStream, savedSingleton);
            }

            using (Stream readStream = new FileStream("singleton.bin",
                FileMode.Open,
                FileAccess.Read,
                FileShare.Read))
            {
                var readedSingleton = (SerializableSingleton)formatter.Deserialize(readStream);
                Assert.AreSame(savedSingleton, readedSingleton);
            }
        }
    }
}
