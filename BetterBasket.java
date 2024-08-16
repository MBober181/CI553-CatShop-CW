package catalogue;

import java.io.Serializable;
import java.util.Comparator;

/**
 * The BetterBasket class extends Basket to improve product management by:
 * - consolidating products with the same product number by summing their quantities
 *
 * @version 1.1
 */
public class BetterBasket extends Basket implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Adds a product to the basket. If a product with the same product number
   * already exists in the basket, it increases its quantity instead of adding
   * a new entry.
   *
   * @param product The product to be added.
   * @return true if the product is added or its quantity is updated successfully.
   */
  @Override
  public boolean add(Product product) {
    System.out.println("Adding product: " + product);

    // Check if product already exists in basket
    // If exists, increase quantity
    boolean updated = false;
    for (Product p : this) {
      if (p.getProductNum().equals(product.getProductNum())) {
        System.out.println("Product already exists. Updating quantity.");
        p.setQuantity(p.getQuantity() + product.getQuantity());
        updated = true;
        break;
      }
    }
    if (!updated) {
      // If product does not exist, add it
      System.out.println("Product does not exist. Adding new product.");
      super.add(product);
    }

    sortBasket();
    System.out.println("Basket after addition: " + this);
    return true;
  }

  private void sortBasket() {
    // Sort basket by product number (String comparison)
    System.out.println("Sorting basket.");
    this.sort(Comparator.comparing(Product::getProductNum));
    System.out.println("Basket after sorting: " + this);
  }

  // Method to remove last product from basket
  public void removeLastProduct() {
    if (!isEmpty()) {
      System.out.println("Removing last product from the basket.");
      Product removedProduct = get(quantity() - 1);
      remove(quantity() - 1);
      System.out.println("Removed product: " + removedProduct);
    } else {
      System.out.println("Basket is empty. Cannot remove product.");
      System.out.println("Basket is empty. Cannot remove product.");
    }
  }

  private int quantity() {
    return this.size(); // Return actual number of items in basket
  }


}











