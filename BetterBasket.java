package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
import java.util.Collections;

public class BetterBasket extends Basket {
    private static final long serialVersionUID = 1L;
    @Override
    public boolean add(Product pr) {
        // Check if the product is already in the basket
        for (Product existingProduct : this) {
            if (existingProduct.getProductNum().equals(pr.getProductNum())) {
                // If it is, merge the quantities and return
                existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
                return true;
            }
        }

        // If the product is not in the basket, add it
        boolean added = super.add(pr);

        // Sort the basket based on product numbers
        Collections.sort(this, (p1, p2) -> Integer.compare(Integer.parseInt(p1.getProductNum()), Integer.parseInt(p2.getProductNum())));

        return added;
    }

    // Additional methods if needed for enhanced functionality
    // ...
}
