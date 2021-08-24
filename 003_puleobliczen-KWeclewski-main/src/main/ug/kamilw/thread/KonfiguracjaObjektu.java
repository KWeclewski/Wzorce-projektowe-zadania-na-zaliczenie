package main.ug.kamilw.thread;

import main.ug.kamilw.model.TypObliczenEnum;

public class KonfiguracjaObjektu {
    private TypObliczenEnum typ;
    private int iteracji;
    private int liczbaObjektow;

    private KonfiguracjaObjektu(Builder builder) {
        this.typ = builder.typ;
        this.iteracji = builder.iteracji;
        this.liczbaObjektow = builder.liczbaObjektow;
    }

    public int getIteracji() {
        return this.iteracji;
    }

    public int getLiczbaObjektow() {
        return this.liczbaObjektow;
    }

    public TypObliczenEnum getTyp() {
        return this.typ;
    }

    public static class Builder {
        TypObliczenEnum typ;
        int iteracji = 1;
        int liczbaObjektow = 1;

        private Builder(){}

        public static Builder builder() {
            return new Builder();
        }

        public Builder withTyp(TypObliczenEnum typ) {
            this.typ = typ;
            return this;
        }

        public Builder withLiczbaObjektow(int liczbaObjektow) {
            if (liczbaObjektow < 1) {
                throw new IllegalArgumentException("Wrong objects number!");
            }
            this.liczbaObjektow = liczbaObjektow;
            return this;
        }
        public Builder withIteracji(int iteracji) {
            if (iteracji < 1) {
                throw new IllegalArgumentException("Wrong iterations number!");
            }
            this.iteracji = iteracji;
            return this;
        }


        public KonfiguracjaObjektu build(){
            if (typ == null) {
                throw new RuntimeException("Wrong calc type!");
            }
            return new KonfiguracjaObjektu(this);
        }
    }
}
