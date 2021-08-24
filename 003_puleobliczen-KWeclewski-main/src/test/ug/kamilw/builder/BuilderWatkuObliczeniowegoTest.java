package test.ug.kamilw.builder;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.model.Wartosc;
import main.ug.kamilw.pool.PodstawowaPulaWartosci;
import main.ug.kamilw.pool.PulaObjektow;
import main.ug.kamilw.pool.ZaawansowanaPulaWartosci;
import main.ug.kamilw.thread.KonfiguracjaObjektu;
import main.ug.kamilw.thread.WatekObliczajacy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BuilderWatkuObliczeniowegoTest {

    @Mock
    ZaawansowanaPulaWartosci zaawansowanaPulaWartosci;
    @Mock
    PodstawowaPulaWartosci podstawowaPulaWartosci;
    Map<TypObliczenEnum, PulaObjektow> mapa;

    @BeforeEach
    public void setUp() {
        mapa = new HashMap<>();
        mapa.put(TypObliczenEnum.PROSTY, podstawowaPulaWartosci);
        mapa.put(TypObliczenEnum.KOMPLEKSOWY , zaawansowanaPulaWartosci);
    }

    @Test
    public void buildPoprawnyWatekObliczajacy() {
        Wartosc war = new Wartosc(2);
        KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder().withTyp(TypObliczenEnum.PROSTY).build();
        WatekObliczajacy watek = WatekObliczajacy.Builder.builder()
                .withObliczenia(konfiguracjaObjektu)
                .withWartosc(war)
                .withPuleObjektow(mapa)
                .build();
        assertThat(watek)
                .isNotNull()
                .matches(e ->
                        konfiguracjaObjektu.equals(e.getKonfiguracjaObliczen().getFirst())
                                && war.equals(e.getWartosc())
                                && mapa.equals(e.getPulaObliczen()));
    }

    @Test
    public void throwExceptionZlaPulaObjektow() {
        Wartosc war = new Wartosc(2);
        KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder().withTyp(TypObliczenEnum.PROSTY).build();
        mapa.remove(TypObliczenEnum.PROSTY);
        assertThatThrownBy(() -> WatekObliczajacy.Builder.builder()
                .withObliczenia(konfiguracjaObjektu)
                .withWartosc(war)
                .withPuleObjektow(mapa)
                .build()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwExceptionBrakWartosci() {
        KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder().withTyp(TypObliczenEnum.PROSTY).build();
        assertThatThrownBy( () -> WatekObliczajacy.Builder.builder()
                .withObliczenia(konfiguracjaObjektu)
                .withPuleObjektow(mapa)
                .build()).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionBrakMapyPuliObiektow() {
        KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder().withTyp(TypObliczenEnum.PROSTY).build();
        Wartosc war = new Wartosc(2);
        assertThatThrownBy( () -> WatekObliczajacy.Builder.builder()
                .withObliczenia(konfiguracjaObjektu)
                .withWartosc(war)
                .build()).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionBrakKonfiguracjiObjektu() {
        Wartosc war = new Wartosc(2);
        assertThatThrownBy( () -> WatekObliczajacy.Builder.builder()
                .withPuleObjektow(mapa)
                .withWartosc(war)
                .build()).isInstanceOf(RuntimeException.class);
    }
}