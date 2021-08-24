package market.ug.kamilw.visitor;

import market.ug.kamilw.model.Offer;

public class SmallDecreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(-.1);
    }
}
