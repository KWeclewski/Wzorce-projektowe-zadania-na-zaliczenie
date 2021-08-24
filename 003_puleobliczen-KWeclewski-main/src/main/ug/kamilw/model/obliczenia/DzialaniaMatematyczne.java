package main.ug.kamilw.model.obliczenia;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.model.Wartosc;

public abstract class DzialaniaMatematyczne implements Cloneable{
    protected double _wartosc;
    protected int iteracji = 1;

    public DzialaniaMatematyczne(double wartosc) {
        _wartosc = wartosc;
    }

    public int getIteracji() {
        return iteracji;
    }

    public void setWartosc(double wartosc) {
        this._wartosc = wartosc;
    }

    public double getWartosc() {
        return _wartosc;
    }
    public void setIteracji(int iteracji) {
        this.iteracji = iteracji;
    }

    public abstract Wartosc getPrzeliczonaWartosc(Wartosc v);

    public abstract TypObliczenEnum getTyp();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();

        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }

        return clone;
    }
    public void withIteracje(int iteracji) {
        this.iteracji = iteracji;
    }
}
