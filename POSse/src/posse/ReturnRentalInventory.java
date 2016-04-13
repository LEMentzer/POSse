/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;
import java.sql.*;
/**
 *
 * @author Lauren
 */
public class ReturnRentalInventory {
private static PersistentStorage data = null;
    ReturnRentalInventory() throws SQLException{
        data = PersistentStorage.getInstance();
    }
    public boolean checkItem(int itemID){
        try{
            return data.checkItem(itemID);
        }
        catch(SQLException e){
            
        }
        return false;
    }
    public boolean incrementQuantity(int itemID, int quantity, double price){
        //double price = getPrice(itemID);
        if(price == -1){
            return false;
        }
        else{
            return data.returnRentalIncrementQuantity(itemID, quantity, price);
        }
        
    }

    public double getPrice(int itemID){
        return data.rentalgetPrice(itemID);
    }
    public int getQuantity(int itemID){
        return data.returnRentalGetQuantity(itemID);
    }
    public String getDescription(int itemID){
        return data.getDescription(itemID);
    }
    public String getName(int itemID){
        return data.getName(itemID);
    }
}

