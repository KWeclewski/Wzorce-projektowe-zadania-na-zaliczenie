package test.ug.kamilw.pool;

import main.ug.kamilw.model.obliczenia.ZaawansowaneDzialaniaMatematyczne;
import main.ug.kamilw.pool.ZaawansowanaPulaWartosci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZaawansowanaPulaTest {
    ZaawansowanaPulaWartosci zaawansowanaPulaWartosci;

    @BeforeEach
    public void setUp() {
        ZaawansowaneDzialaniaMatematyczne zaawansowaneDzialaniaMatematyczne = new ZaawansowaneDzialaniaMatematyczne( 2);
        zaawansowanaPulaWartosci = new ZaawansowanaPulaWartosci(zaawansowaneDzialaniaMatematyczne);
    }

    @Test
    public void TestSprawdzSieWpis() {
        zaawansowanaPulaWartosci.sprawdzSie();
        zaawansowanaPulaWartosci.sprawdzSie();
        zaawansowanaPulaWartosci.sprawdzSie();
        assertThat(zaawansowanaPulaWartosci)
                .matches(e -> e.getWUzyciu().size() == 3)
                .matches(e -> e.getWolne().size() == 0);
    }

    @Test
    public void TestSprawdzWypis() {
        ZaawansowaneDzialaniaMatematyczne zdm1, zdm2, zdm3;
        zdm1 = zaawansowanaPulaWartosci.sprawdzSie();
        zdm2 = zaawansowanaPulaWartosci.sprawdzSie();
        zdm3 = zaawansowanaPulaWartosci.sprawdzSie();

        zaawansowanaPulaWartosci.sprawdz(zdm1);
        zaawansowanaPulaWartosci.sprawdz(zdm2);

        assertThat(zaawansowanaPulaWartosci)
                .matches(e -> e.getWUzyciu().size() == 1)
                .matches(e -> e.getWolne().size() == 2);
    }
}