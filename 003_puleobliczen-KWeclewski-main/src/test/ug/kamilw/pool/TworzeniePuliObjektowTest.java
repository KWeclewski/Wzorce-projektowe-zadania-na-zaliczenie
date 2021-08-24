package test.ug.kamilw.pool;

import main.ug.kamilw.model.obliczenia.PodstawoweDzialaniaMatematyczne;
import main.ug.kamilw.model.obliczenia.ZaawansowaneDzialaniaMatematyczne;
import main.ug.kamilw.pool.PodstawowaPulaWartosci;
import main.ug.kamilw.pool.PulaObjektow;
import main.ug.kamilw.pool.ZaawansowanaPulaWartosci;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TworzeniePuliObjektowTest {
    @Test
    public void stworzPodstawowaPule() {
        PodstawoweDzialaniaMatematyczne podstawoweDzialaniaMatematyczne = new PodstawoweDzialaniaMatematyczne(2);
        PodstawowaPulaWartosci podstawowaPulaWartosci = new PodstawowaPulaWartosci(podstawoweDzialaniaMatematyczne);
        assertThat(podstawowaPulaWartosci)
                .isNotNull()
                .isInstanceOf(PodstawowaPulaWartosci.class);
        assertThat(podstawowaPulaWartosci.prototyp)
                .isEqualTo(podstawoweDzialaniaMatematyczne);
    }

    @Test
    public void stworzZaawansowanaPule() {
        ZaawansowaneDzialaniaMatematyczne zaawansowaneDzialaniaMatematyczne = new ZaawansowaneDzialaniaMatematyczne(2);
        ZaawansowanaPulaWartosci zaawansowanaPulaWartosci = new ZaawansowanaPulaWartosci(zaawansowaneDzialaniaMatematyczne);
        assertThat(zaawansowanaPulaWartosci)
                .isNotNull()
                .isInstanceOf(ZaawansowanaPulaWartosci.class);
        assertThat(zaawansowanaPulaWartosci.prototyp)
                .isEqualTo(zaawansowaneDzialaniaMatematyczne);
    }
}