package main.ug.kamilw.pool;

import main.ug.kamilw.model.obliczenia.PodstawoweDzialaniaMatematyczne;

public class PodstawowaPulaWartosci extends PulaObjektow<PodstawoweDzialaniaMatematyczne> {
    public PodstawowaPulaWartosci(PodstawoweDzialaniaMatematyczne prototyp) {
        super(prototyp);
    }

    @Override
    protected PodstawoweDzialaniaMatematyczne create() {
        return (PodstawoweDzialaniaMatematyczne) prototyp.clone();
    }

    @Override
    protected void reset(PodstawoweDzialaniaMatematyczne object) {
        object.setWartosc(prototyp.getWartosc());
        object.setIteracji(1);
    }
}
