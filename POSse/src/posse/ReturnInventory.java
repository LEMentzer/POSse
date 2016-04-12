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
public class ReturnInventory {
private static PersistentStorage data = null;
    ReturnInventory() throws SQLException{
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
            return data.returnIncrementQuantity(itemID, quantity, price);
        }
        
    }

    public double getPrice(int itemID){
        return data.getPrice(itemID);
    }
    public int getQuantity(int itemID){
        return data.returngetQuantity(itemID);
    }
    public String getDescription(int itemID){
        return data.getDescription(itemID);
    }
    public String getName(int itemID){
        return data.getName(itemID);
    }
}

