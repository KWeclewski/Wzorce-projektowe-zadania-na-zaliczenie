package market;

import market.ug.kamilw.model.Offer;
import market.ug.kamilw.model.Product;
import market.ug.kamilw.visitor.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorTest {

    @Mock
    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;
    private double HIGH_INCREASE_MUL = .123;
    private double HIGH_DECREASE_MUL = -.123;
    private double SMALL_DECREASE_MUL = -.1;
    private double SMALL_INCREASE_MUL = .1;
    Product product;
    Offer offer;

    @BeforeEach
    public void setUp() {
        offer = new Offer(product, PRICE, PRODUCTION_COST);
    }


    @Test
    public void testHighDecreaseVisitOffer() {
        MarketVisitor visitor = new HighDecreaseVisitor();

        visitor.visit(offer);

        assertThat(offer.getPrice())
                .isEqualTo(PRICE + PRICE * HIGH_DECREASE_MUL);
    }

    @Test
    public void testSmallDecreaseVisitOffer() {
        MarketVisitor visitor = new SmallDecreaseVisitor();

        visitor.visit(offer);

        assertThat(offer.getPrice())
                .isEqualTo(PRICE + PRICE * SMALL_DECREASE_MUL);
    }

    @Test
    public void testSmallIncreaseVisitOffer() {
        MarketVisitor visitor = new SmallIncreaseVisitor();

        visitor.visit(offer);

        assertThat(offer.getPrice())
                .isEqualTo(PRICE + PRICE * SMALL_INCREASE_MUL);
    }

    @Test
    public void testHighIncreaseVisitOffer() {
        MarketVisitor visitor = new HighIncreaseVisitor();

        visitor.visit(offer);

        assertThat(offer.getPrice())
                .isEqualTo(PRICE + PRICE * HIGH_INCREASE_MUL);
    }

}
