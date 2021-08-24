package test.ug.kamilw.pool;

import main.ug.kamilw.model.obliczenia.PodstawoweDzialaniaMatematyczne;
import main.ug.kamilw.pool.PodstawowaPulaWartosci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PodstawowaPulaTest {
    PodstawowaPulaWartosci podstawowaPulaWartosci;

    @BeforeEach
    public void setUp() {
        PodstawoweDzialaniaMatematyczne podstawoweDzialaniaMatematyczne = new PodstawoweDzialaniaMatematyczne(2);
        podstawowaPulaWartosci = new PodstawowaPulaWartosci(podstawoweDzialaniaMatematyczne);
    }

    @Test
    public void TestSprawdzaniaSieWPuli() {
        podstawowaPulaWartosci.sprawdzSie();
        podstawowaPulaWartosci.sprawdzSie();
        podstawowaPulaWartosci.sprawdzSie();
        assertThat(podstawowaPulaWartosci)
                .matches(e -> e.getWUzyciu().size() == 3)
                .matches(e -> e.getWolne().size() == 0);
    }

    @Test
    public void TestSprawdzaniaIWypisaniaZPuli() {
        PodstawoweDzialaniaMatematyczne pdm1, pdm2, pdm3;
        pdm1 = podstawowaPulaWartosci.sprawdzSie();
        pdm2 = podstawowaPulaWartosci.sprawdzSie();
        pdm3 = podstawowaPulaWartosci.sprawdzSie();
        podstawowaPulaWartosci.sprawdz(pdm1);
        podstawowaPulaWartosci.sprawdz(pdm2);
        assertThat(podstawowaPulaWartosci)
                .matches(e -> e.getWUzyciu().size() == 1)
                .matches(e -> e.getWolne().size() == 2);
    }
}
