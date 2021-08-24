package market.ug.kamilw.observer;

import market.ug.kamilw.model.Offer;

public interface OfferObserver {
    void update(Offer offer);
}
