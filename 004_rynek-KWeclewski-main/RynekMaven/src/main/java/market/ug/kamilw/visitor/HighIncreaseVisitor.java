package market.ug.kamilw.visitor;

import market.ug.kamilw.model.Offer;

public class HighIncreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(.123);
    }
}
