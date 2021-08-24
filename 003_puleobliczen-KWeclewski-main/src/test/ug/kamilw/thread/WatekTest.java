package test.ug.kamilw.thread;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.model.Wartosc;
import main.ug.kamilw.model.obliczenia.PodstawoweDzialaniaMatematyczne;
import main.ug.kamilw.model.obliczenia.ZaawansowaneDzialaniaMatematyczne;
import main.ug.kamilw.pool.PodstawowaPulaWartosci;
import main.ug.kamilw.pool.PulaObjektow;
import main.ug.kamilw.pool.ZaawansowanaPulaWartosci;
import main.ug.kamilw.thread.KonfiguracjaObjektu;
import main.ug.kamilw.thread.WatekObliczajacy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

public class WatekTest {
    ExecutorService exService;
    Map<TypObliczenEnum, PulaObjektow> mapa = new HashMap<>();

    @BeforeEach
    public void setUp() {
        mapa = new HashMap<>();
        mapa.put(TypObliczenEnum.PROSTY, new PodstawowaPulaWartosci(new PodstawoweDzialaniaMatematyczne(2)));
        mapa.put(TypObliczenEnum.KOMPLEKSOWY, new ZaawansowanaPulaWartosci(new ZaawansowaneDzialaniaMatematyczne(2)));
    }

    @Test
    public void sprawdzaniePoprawnosciZwracanegoWyniku() {
        WatekObliczajacy watekObliczajacy = WatekObliczajacy.Builder.builder()
                .withWartosc(new Wartosc(2))
                .withObliczenia(KonfiguracjaObjektu.Builder.builder()
                        .withTyp(TypObliczenEnum.KOMPLEKSOWY).build())
                .withPuleObjektow(mapa).build();

        Wartosc war = watekObliczajacy.call();
        assertThat(war.getWartosc()).isEqualTo((Math.pow(2, 3)*Math.pow(2, 4)));
    }

    @Test
    public void sprawdzaniePoprawnosciZwracanegoWynikuDlaDwochTypow() {
        WatekObliczajacy watekObliczajacy = WatekObliczajacy.Builder.builder()
                .withWartosc(new Wartosc(2))
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.PROSTY).build())
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.KOMPLEKSOWY).build())
                .withPuleObjektow(mapa).build();
        Wartosc war = watekObliczajacy.call();
        double wartoscProstaKompleksowa = Math.sqrt(Math.pow(Math.pow(2, 3)*Math.pow(2, 4), 2));
        assertThat(war.getWartosc()).isEqualTo(wartoscProstaKompleksowa);

    }

    @Test
    public void watekZWielomaObliczeniami() {
        WatekObliczajacy watekObliczajacy = WatekObliczajacy.Builder.builder()
                .withWartosc(new Wartosc(new Random().nextDouble()))
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.PROSTY).withLiczbaObjektow(3).withIteracji(100).build())
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.KOMPLEKSOWY).withLiczbaObjektow(3).withIteracji(100).build())
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.PROSTY).withLiczbaObjektow(3).withIteracji(100).build())
                .withObliczenia(KonfiguracjaObjektu.Builder.builder().
                        withTyp(TypObliczenEnum.KOMPLEKSOWY).withLiczbaObjektow(3).withIteracji(100).build())
                .withPuleObjektow(mapa)
                .build();
        Wartosc war = watekObliczajacy.call();
        assertThat(war)
                .isNotNull();
    }

    @Test
    public void wykonajDziesiecWatkowProstegoTypu() throws InterruptedException {
        exService = Executors.newFixedThreadPool(10);
        List<WatekObliczajacy> listaWatkow = utworzWatekZProstymTypem(1000);
        exService.invokeAll(listaWatkow);
        exService.shutdown();
        assertThat(mapa.get(TypObliczenEnum.PROSTY))
                .matches(e -> e.getWUzyciu().size() == 0 && e.getWolne().size() >= 1);    }

    @Test
    public void wykonajStoWatkowProstegoTypu() throws InterruptedException {
        exService = Executors.newFixedThreadPool(100);
        List<WatekObliczajacy> listaWatkow = utworzWatekZProstymTypem(1000);
        exService.invokeAll(listaWatkow);
        exService.shutdown();
        assertThat(mapa.get(TypObliczenEnum.PROSTY))
                .matches(e -> e.getWUzyciu().size() == 0 && e.getWolne().size() >= 1);
    }

    private List<WatekObliczajacy> utworzWatekZProstymTypem(int jakWiele) {
        List<WatekObliczajacy> listaWatkow = new ArrayList<>();
        for (int i = 0; i < jakWiele; i++) {
            WatekObliczajacy watekObliczajacy = WatekObliczajacy.Builder.builder()
                    .withWartosc(new Wartosc(new Random().nextDouble()))
                    .withObliczenia(KonfiguracjaObjektu.Builder.builder()
                            .withTyp(TypObliczenEnum.PROSTY)
                            .withLiczbaObjektow(new Random().nextInt(5) + 1)
                            .withIteracji(new Random().nextInt(100) + 1).build())
                    .withPuleObjektow(mapa)
                    .build();
            listaWatkow.add(watekObliczajacy);
        }
        return listaWatkow;
    }
}