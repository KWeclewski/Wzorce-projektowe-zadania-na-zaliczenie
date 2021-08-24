using System;
using System.Collections.Generic;
using System.Text;

namespace Fabryki.SimpleFactory
{
    class TeaGreen : Product
    {
        public TeaGreen()
        {
            this.CreateProduct();
        }
    }

    class TeaWhite : Product
    {
        public TeaWhite()
        {
            this.CreateProduct();
        }
    }

    class TeaBlack : Product
    {
        public TeaBlack()
        {
            this.CreateProduct();
        }
    }

    class TeaRaspberry : Product
    {
        public TeaRaspberry()
        {
            this.CreateProduct();
        }
    }

    class TeaOrange : Product
    {
        public TeaOrange()
        {
            this.CreateProduct();
        }
    }
}
