package posse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Rental
 * 
 * Description:
 * 
 */
public class Rental extends Transaction{
    ArrayList<RentalItem> rentals;
    double total;
    double subtotal;
    double tax;
    String receipt;
    
    Rental() {
        this.total = 0;
        this.subtotal = 0;
        this.tax = 0;
        this.rentals = new ArrayList();
    }
    
    // Item(int itemID, String name, double price, boolean taxable)
    // SaleItem(Item item, int quantity, double total)
    RentalItem addItem(int input, int quantity) throws SQLException {
        RentInventory inv = new RentInventory();
        if(!inv.checkItem(input)) {
            // maybe return string saying invalid item?
            return null;
        }
        Double price = inv.getPrice(input);
        String name = inv.getName(input);
        // GET NAME
        Item it = new Item(input, name, price, true);
        RentalItem ri = new RentalItem(it, quantity, price*quantity, 30);
        rentals.add(ri);
        inv.decrementQuantity(input, quantity);
        return ri;
    }
    
    Boolean removeItem(int input, int quantity) {
        return false;
    }
    
    double calculateSubtotal() {
        for(int i = 0; i < rentals.size(); i++) {
            subtotal =+ (rentals.get(i).getTotal());
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
        tax = calculateTax();
        total = tax + subtotal;
        return total;
    }
    
    RentalReceipt printReceipt() {
        RentalReceipt receipt = new RentalReceipt(rentals, total, tax, subtotal);
        return receipt;
    }
    
}
