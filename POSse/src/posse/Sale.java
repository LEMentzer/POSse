package posse;
import java.util.ArrayList;

/**
 *
 * Sale
 * 
 * Description:
 * 
 */
public class Sale {
    ArrayList<SaleItem> purchases;
    double total;
    double subtotal;
    double tax;
    
    Sale() {
        this.total = 0;
        this.subtotal = 0;
        this.tax = 0;
    }
    
    Boolean addItem(SaleItem s, int quantity) {
        for(int i = 0; i < quantity; i++) {
            purchases.add(s);
        }
        // get Inventory instance
        // check to make sure item is in there
        return true;
    }
    
    Boolean removeItem(SaleItem s, int quantity) {
        Boolean success = purchases.remove(s);
        // get Inventory instance
        // add item back to inventory
        return success;
    }
    
    double calculateSubtotal() {
        // get inventory instance
        // add corresponding prices
        return subtotal;
    }
    
    double calculateTax() {
        tax = subtotal * 0.0875;
        return tax;
    }
    
    double calculateTotal() {
        total = subtotal * (1 + tax);
        return total;
    }
    
}
