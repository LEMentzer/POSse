package posse;

import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * 
 */
public class Returns extends Transaction{
    ArrayList<ReturnItem> returns;
    double returnTotal;
    double returnSubtotal;
    double returnTax;
    
    Returns() {
        returns = new ArrayList();
        returnTotal = 0;
        returnSubtotal = 0;
        returnTax = 0;
    }
    ReturnItem addRentalItem(int input, int quantity) throws SQLException {
        RentInventory inv = new RentInventory();
        ReturnRentalInventory retinv = new ReturnRentalInventory();
        if(!inv.checkItem(input)) {
            System.out.println("not in inventory");
            return null;
        }
        double price = inv.getPrice(input);
        String name = inv.getName(input);
        Item it = new Item(input, name, price, true);
        ReturnItem ret = new ReturnItem(it, quantity, price*quantity);
        returns.add(ret);
        
        // increment quantity bc adding return
        retinv.incrementQuantity(input, quantity, price);
        return ret;
    }
    ReturnItem addItem(int input, int quantity) throws SQLException {
        ReturnInventory retinv = new ReturnInventory();
        if(!retinv.checkItem(input)) {
            return null;
        }
        double price = retinv.getPrice(input);
        String name = retinv.getName(input);
        Item it = new Item(input, name, price, true);
        ReturnItem ret = new ReturnItem(it, quantity, price*quantity);
        returns.add(ret);
        
        retinv.incrementQuantity(input, quantity, price);
        return ret;
    }
    
    Boolean removeItem(int input, int quantity) throws SQLException {
        return true;
    }
    
    double calculateSubtotal() {
        returnSubtotal = 0;
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
        
        returnTotal = 0;
        returnTotal = returnTax + returnSubtotal;
        return returnTotal;
    }
    
    Receipt printReceipt() {
        ReturnReceipt r = new ReturnReceipt(returns, returnTotal, returnTax, returnSubtotal);
        return r;
    }
}
