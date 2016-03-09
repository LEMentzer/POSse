/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

import java.sql.*;


/**
 *
 * Inventory
 * 
 * Description:
 * 
 */
public class Inventory {
    private static PersistentStorage data = null;
    Inventory() throws SQLException{
        data = PersistentStorage.getInstance();
    }
    public boolean checkItem(int itemID){
        return data.checkItem(itemID);
    }
    public boolean incrementQuantity(int itemID, int quantity){
        return data.incrementQuantity(itemID, quantity);
    }
    public boolean decrementQuantity(int itemID, int quantity){
        return data.decrementQuantity(itemID, quantity);
    }
    public double getPrice(int itemID){
        return data.getPrice(itemID);
    }
    public int getQuantity(int itemID){
        return data.getQuantity(itemID);
    }
    public String getDescription(int itemID){
        return data.getDescription(itemID);
    }
}
