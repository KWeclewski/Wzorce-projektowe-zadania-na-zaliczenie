package market.ug.kamilw.visitor;

import market.ug.kamilw.model.Offer;

public class HighDecreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(-.123);
    }
}
