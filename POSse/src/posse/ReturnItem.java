package posse;

/**
 *
 * @author Irene
 */
public class ReturnItem {
    private Item item;
    private int quantity;
    private double total = 0;
  
    ReturnItem(Item item, int quantity, double total) {
        this.item = item;
        this.quantity = quantity;
        this.total = total;
    }
  
    Item getItem() {
        return item;
    }
  
    int getQuantity() {
        return quantity;
    }
  
    double getTotal() {
        return total;
    }
  
    void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
