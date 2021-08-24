package test.ug.kamilw.builder;

import main.ug.kamilw.model.TypObliczenEnum;
import main.ug.kamilw.thread.KonfiguracjaObjektu;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuilderKonfiguracjiObjektuTest {

    @Test
    public void buildKonfiguracjeObjektuZeWszystkimiPolami() {
    TypObliczenEnum typ = TypObliczenEnum.PROSTY;
    int liczbaObjektow = 10;
    int iteracji = 15;
    KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder()
            .withTyp(typ)
            .withLiczbaObjektow(liczbaObjektow)
            .withIteracji(iteracji)
            .build();
    assertThat(konfiguracjaObjektu)
            .matches(e -> e.getIloscObjektow() == liczbaObjektow)
            .matches(e -> e.getIteracji() == iteracji)
            .matches(e -> TyopObliczenEnum.PROSTY.equals(e.getTyp()));
    }

    @Test
    public void buildObjektZeZlaKonfiguracja() {
    TypObliczenEnum typ = TypObliczenEnum.PROSTY;
    KonfiguracjaObjektu konfiguracjaObjektu = KonfiguracjaObjektu.Builder.builder()
            .withTyp(typ)
            .build();
    assertThat(konfiguracjaObjektu)
            .matches(e -> e.getIloscObjektow() == 1)
            .matches(e -> e.getIteracji() == 1)
            .matches(e -> TypObliczenEnum.Prosty.equals(e.getTyp()));
}

    @Test
    public void throwExceptionZlyTyp() {
    Assertions.assertThatThrownBy( () -> KonfiguracjaObjektu.Builder.builder().build())
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void throwExceptionZlaIteracja() {
    TypObliczenEnum typ = TypObliczenEnum.PROSTY;
    int iteracji = 0;
    Assertions.assertThatThrownBy( () -> KonfiguracjaObjektu.Builder.builder()
            .withTyp(typ)
            .withIteracji(iteracji).build())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void throwExceptionZlaLiczbaObjektow() {
    TypObliczenEnum typ = TypObliczenEnum.PROSTY;
    int liczbaObjektow = 0;
    assertThatThrownBy( () -> KonfiguracjaObjektu.Builder.builder()
            .withTyp(typ)
            .withIteracji(liczbaObjektow).build())
            .isInstanceOf(IllegalArgumentException.class);
    }
}