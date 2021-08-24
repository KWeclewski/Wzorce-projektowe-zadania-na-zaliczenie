package main.ug.kamilw.pool;

import main.ug.kamilw.model.obliczenia.ZaawansowaneDzialaniaMatematyczne;

public class ZaawansowanaPulaWartosci extends PulaObjektow<ZaawansowaneDzialaniaMatematyczne> {

    public ZaawansowanaPulaWartosci(ZaawansowaneDzialaniaMatematyczne prototyp){
        super(prototyp);
    }

    @Override
    protected ZaawansowaneDzialaniaMatematyczne create() {
        return (ZaawansowaneDzialaniaMatematyczne) prototyp.clone();
    }

    @Override
    protected void reset(ZaawansowaneDzialaniaMatematyczne objekt) {
        objekt.setWartosc(prototyp.getWartosc());
        objekt.setIteracji(1);
    }
}
