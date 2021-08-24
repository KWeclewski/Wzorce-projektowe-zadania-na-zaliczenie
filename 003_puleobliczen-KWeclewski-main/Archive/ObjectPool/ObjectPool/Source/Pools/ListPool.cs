using System;
using System.Collections.Generic;
using System.Text;

namespace ObjectPool.Source.Pools
{
    public static class ListPool<T>
    {
        private static list<> _available = new list<t>();
        private static list<t> _inuse = new list<t>();

        public static t getobject()
        {
            lock (_available)
            {
                if (_available.count != 0)
                {
                    t worker = _available[0];
                    _inuse.add(worker);
                    _available.removeat(0);
                    return worker;
                }
                else
                {
                    t worker = new t();
                    _inuse.add(worker);
                    return worker;
                }
            }
        }

        public static void releaseobject(worker po)
        {
            cleanup(po);

            lock (_available)
            {
                _available.add(po);
                _inuse.remove(po);
            }
        }

        private static void cleanup(worker po)
        {
            //po.tempdata = null;
        }
    }
}
