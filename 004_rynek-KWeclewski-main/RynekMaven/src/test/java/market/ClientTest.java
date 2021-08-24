package market;

import market.ug.kamilw.model.*;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {
    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;
    private double INTEREST = 0.5;
    @Mock
    Seller seller;
    private final Client client = new Client("Client1");
    private final Bank bank = Bank.getInstance();

    @Test
    public void followOffer() {
        Offer offer = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        offer.setSeller(seller);
        client.followOffer(offer);
        assertThat(client.getInterests())
                .isNotNull()
                .hasSize(1);
    }

    @Test
    public void updateAfterInflation() {
        Offer offer1 = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        offer1.setSeller(seller);
        Offer offer2 = new Offer(new Product("Product2"), PRICE, PRODUCTION_COST);
        offer2.setSeller(seller);
        client.followOffer(offer1);
        client.followOffer(offer2);
        client.getInterests().forEach(e -> e.setInterest(INTEREST));

        bank.setInflation(bank.getInflation() + 0.3);

        List<Double> prices = client.getInterests()
                .stream()
                .map(Interest::getInterest)
                .collect(Collectors.toList());

        assertThat(prices)
                .doesNotContain(INTEREST, INTEREST)
                .allMatch(e -> e < INTEREST);
    }
}
