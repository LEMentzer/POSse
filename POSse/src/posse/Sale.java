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
public class Sale {
    ArrayList<SaleItem> purchases;
    double total;
    double subtotal;
    double tax;
    String receipt;
    
    Sale() {
        this.total = 0;
        this.subtotal = 0;
        this.tax = 0;
    }
    
    // Item(int itemID, String name, double price, boolean taxable)
    // SaleItem(Item item, int quantity, double total)
    Boolean addItem(int input, int quantity) throws SQLException {
        Inventory inv = new Inventory();
        if(!inv.checkItem(input)) {
            // maybe return string saying invalid item?
            return false;
        }
        Double price = inv.getPrice(input);
        // GET NAME
        Item it = new Item(input, "Name", price, true);
        SaleItem si = new SaleItem(it, quantity, price*quantity);
        for(int i = 0; i < quantity; i++) {
            purchases.add(si);
        }
        return true;
    }
    
    Boolean removeItem(int input, int quantity) {
        return false;
    }
    
    double calculateSubtotal() {
        for(int i = 0; i < purchases.size(); i++) {
            subtotal =+ purchases.get(i).getTotal();
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
        total = tax + subtotal;
        return total;
    }
    
    String printReceipt() {
        // prints receipt of items
        StringBuilder sb = new StringBuilder();
        String begin = "RECEIPT: ";
        sb.append(begin);
        for(int i = 0; i < purchases.size(); i++) {
            Item item = purchases.get(i).getItem();
            sb.append("\n");
            sb.append(item.getItemID());
            sb.append("\t");
            sb.append(item.getName());
            sb.append("\t");
            sb.append(purchases.get(i).getQuantity());
        }
        receipt = sb.toString();
        System.out.println(receipt);
        return receipt;
    }
    
}
