package main.ug.kamilw.thread;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.model.Wartosc;
import main.ug.kamilw.pool.PulaObjektow;
import main.ug.kamilw.model.obliczenia.DzialaniaMatematyczne;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;

public class WatekObliczajacy implements Callable<Wartosc> {
    private final LinkedList<KonfiguracjaObjektu> konfiguracjaObliczen;
    private final Map<TypObliczenEnum, PulaObjektow> MapaPuliObjektow;
    private final LinkedList<DzialaniaMatematyczne> obliczeniaDoUruchomienia;
    private Wartosc war;

    private WatekObliczajacy(Builder builder) {
        this.konfiguracjaObliczen = builder.konfiguracjaObjektu;
        this.MapaPuliObjektow = builder.MapaPuliObjektow;
        this.war = builder.war;
        this.obliczeniaDoUruchomienia = new LinkedList<>();
    }

    public LinkedList<KonfiguracjaObjektu> getKonfiguracjaObliczen() {
        return this.konfiguracjaObliczen;
    }

    public Map<TypObliczenEnum, PulaObjektow> getMapaPuliObjektow() {
        return this.MapaPuliObjektow;
    }
    public Wartosc getWar() {
        return war;
    }

    @Override
    public Wartosc call() {
        for (KonfiguracjaObjektu konfiguracja : konfiguracjaObliczen) {
            PulaObjektow pulaObjektow = MapaPuliObjektow.get(konfiguracja.getTyp());
            for (int i = 0; i < konfiguracja.getLiczbaObjektow(); i++) {
                DzialaniaMatematyczne dzialania = (DzialaniaMatematyczne) pulaObjektow.sprawdzSie();
                dzialania.withIteracje(konfiguracja.getIteracji());
                obliczeniaDoUruchomienia.addLast(dzialania);
            }
        }
        for (DzialaniaMatematyczne dzialania : obliczeniaDoUruchomienia) {
            this.war = dzialania.getPrzeliczonaWartosc(this.war);
            MapaPuliObjektow.get(dzialania.getTyp()).sprawdz(dzialania);
        }
        return this.war;
    }

    public static class Builder {
        LinkedList<KonfiguracjaObjektu> konfiguracjaObjektu = new LinkedList<>();
        Map<TypObliczenEnum, PulaObjektow> MapaPuliObjektow;
        Wartosc war;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withWartosc(Wartosc war) {
            this.war = war;
            return this;
        }

        public Builder withPuleObjektow(Map<TypObliczenEnum, PulaObjektow> MapaPuliObjektow) {
            if (!MapaPuliObjektow.keySet().containsAll(Arrays.asList(TypObliczenEnum.values()))) {
                throw new IllegalArgumentException("Wrong objectPoolMap!");
            }
            this.MapaPuliObjektow = MapaPuliObjektow;
            return this;
        }

        public Builder withObliczenia(KonfiguracjaObjektu konfiguracjaObliczen) {
            konfiguracjaObjektu.addLast(konfiguracjaObliczen);
            return this;
        }

        public WatekObliczajacy build() {
            if (war == null) {
                throw new RuntimeException("Wrong value!");
            }
            if (MapaPuliObjektow == null) {
                throw new RuntimeException("Wrong object pool!");
            }
            if (konfiguracjaObjektu.isEmpty()) {
                throw new RuntimeException("Wrong configuration!");
            }
            return new WatekObliczajacy(this);
        }
    }
}
