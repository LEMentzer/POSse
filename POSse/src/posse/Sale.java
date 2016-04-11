package posse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Sale
 * 
 * Description:
 * 
 */
public class Sale extends Transaction{
    ArrayList<SaleItem> purchases;
    double total;
    double subtotal;
    double tax;
    
    Sale() {
        this.total = 0;
        this.subtotal = 0;
        this.tax = 0;
        this.purchases = new ArrayList();
    }
    
    // Item(int itemID, String name, double price, boolean taxable)
    // SaleItem(Item item, int quantity, double total)
    SaleItem addItem(int input, int quantity) throws SQLException {
        Inventory inv = new Inventory();
        if(!inv.checkItem(input)) {
            // maybe return string saying invalid item?
            return null;
        }
        Double price = inv.getPrice(input);
        String name = inv.getName(input);
        // GET NAME
        Item it = new Item(input, name, price, true);
        SaleItem si = new SaleItem(it, quantity, price*quantity);
        purchases.add(si);
        inv.decrementQuantity(input, quantity);
        return si;
    }
    
    Boolean removeItem(int input, int quantity) {
        return false;
    }
    
    double calculateSubtotal() {
        for(int i = 0; i < purchases.size(); i++) {
            subtotal += (purchases.get(i).getTotal());
        }
        System.out.println("Subtotal: " + subtotal);
        return subtotal;
    }
    
    double calculateTax() {
        Tax t = new Tax(0.0875);
        tax = t.getTax(subtotal);
        return tax;
    }
    
    double calculateTotal() {
        subtotal = calculateSubtotal();
        tax = calculateTax();
        
        total = tax + subtotal;
        return total;
    }
    
    SaleReceipt printReceipt() {
        SaleReceipt sr = new SaleReceipt(purchases, total, tax, subtotal);
        return sr;
    }
    
    
}
