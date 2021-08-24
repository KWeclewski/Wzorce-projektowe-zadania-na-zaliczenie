package main.ug.kamilw.model.obliczenia;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.model.Wartosc;

public class PodstawoweDzialaniaMatematyczne extends DzialaniaMatematyczne{
    public PodstawoweDzialaniaMatematyczne(double _wartosc) {
        super(_wartosc);
    }

    @Override
    public Wartosc getPrzeliczonaWartosc(Wartosc w) {
        Wartosc war = new Wartosc(w.getWartosc());
        for (int i = 0; i < iteracji; i++) {
            war.setWartosc(Math.sqrt(_wartosc)*2);
            _wartosc = war.getWartosc();
        }
        return war;
    }

    @Override
    public TypObliczenEnum getTyp() {
        return TypObliczenEnum.PROSTY;
    }
}