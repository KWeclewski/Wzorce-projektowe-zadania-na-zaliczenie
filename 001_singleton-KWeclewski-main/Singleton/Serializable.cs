using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text;

namespace Singleton
{
    [Serializable]
    public sealed class SingletonSerializationHelper : IObjectReference
    {
        public object GetRealObject(StreamingContext context)
        {
            return SerializableSingleton.GetInstance;
        }
    }

    [Serializable]
    public sealed class SerializableSingleton : ISerializable
    {
        private static readonly SerializableSingleton instance = new SerializableSingleton();
        private SerializableSingleton() { }

        public static SerializableSingleton GetInstance { get { return instance; } }

        public void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.SetType(typeof(SingletonSerializationHelper));
        }
    }
}