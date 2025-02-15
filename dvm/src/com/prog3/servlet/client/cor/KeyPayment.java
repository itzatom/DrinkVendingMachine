package com.prog3.servlet.client.cor;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Key;
import com.prog3.db.ormbean.Product;

import static com.prog3.servlet.client.cor.EPaymentType.KEY;

/**
 * The type Key payment.
 */
public class KeyPayment extends ARequestHandler {

  /**
   * Instantiates a new Key payment.
   *
   * @param r the other block of chain for success set
   */
  public KeyPayment(ARequestHandler r) {
    super(r);
  }

  //handle key payment
  @Override
  public void handlePayment(Payment p) {

    //get the key from purchase and the product
    Key key = p.getPurchase().getKey();
    Product prod = p.getPurchase().getProduct();

    if (key != null) {
      p.setType(KEY);
      //if enough remaining balance than update key and set purchase
      float diff = key.getBalance() - prod.getPrice();
      if (diff >= 0) {
        p.setPaid(true);
        p.getPurchase().setKey(key);
        p.getPurchase().getKey().setBalance(diff);
        new GenericDao<Key>().update(key);

        p.getPurchase().setCash(false);
        p.getPurchase().setCc_number(null);
      } else {
        p.setPaid(false);
      }
    }
    else
      super.handlePayment(p);
  }
}
