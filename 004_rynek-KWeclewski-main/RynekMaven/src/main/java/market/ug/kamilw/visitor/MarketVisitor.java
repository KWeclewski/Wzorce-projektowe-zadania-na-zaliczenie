package market.ug.kamilw.visitor;

import market.ug.kamilw.model.Offer;

public interface MarketVisitor {
    void visit(Offer offer);
}
