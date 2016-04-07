package posse;

import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * 
 */
public class Returns {
    ArrayList<ReturnItem> returns;
    double returnTotal;
    double returnSubtotal;
    double returnTax;
    String returnReceipt;
    
    Returns() {
        returns = new ArrayList();
        returnTotal = 0;
        returnSubtotal = 0;
        returnTax = 0;
    }
    
    ReturnItem addReturn(int input, int quantity) throws SQLException {
        Inventory inv = new Inventory();
        if(!inv.checkItem(input)) {
            return null;
        }
        Double price = inv.getPrice(input);
        String name = inv.getName(input);
        Item it = new Item(input, name, price, true);
        ReturnItem ret = new ReturnItem(it, quantity, price*quantity);
        returns.add(ret);
        
        // increment quantity bc adding return
        inv.incrementQuantity(input, quantity);
        return ret;
    }
    
    Boolean removeReturn(int input, int quantity) throws SQLException {
        Inventory inv = new Inventory();
        if(!inv.checkItem(input)) {
            return false;
        }
        Double price = inv.getPrice(input);
        String name = inv.getName(input);
        Item it = new Item(input, name, price, true);
        ReturnItem ret = new ReturnItem(it, quantity, price*quantity);
        returns.remove(ret);
        
        // decrement quantity
        inv.decrementQuantity(input, quantity);
        return true;
    }
    
    double calculateSubtotal() {
        for(int i = 0; i < returns.size(); i++) {
            returnSubtotal += (returns.get(i).getTotal());
        }
        System.out.println("Return ubtotal: " + returnSubtotal);
        return returnSubtotal;
    }
    
    double calculateTax() {
        Tax t = new Tax(0.0875);
        returnTax = t.getTax(returnSubtotal);
        return returnTax;
    }
    
    double calculateTotal() {
        returnSubtotal = calculateSubtotal();
        returnTax = calculateTax();
        
        returnTotal = returnTax + returnSubtotal;
        return returnTotal;
    }
    
    String printReceipt() {
        returnReceipt = "You will receive " + returnTotal + " in ...";
        return returnReceipt;
    }
}
