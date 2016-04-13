/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;


import java.sql.*;
/**
 *
 * @author ZhuosPC
 */
public class RentInventory {
    private static PersistentStorage data = null;
    RentInventory() throws SQLException{
        data = PersistentStorage.getInstance();
    }
    public boolean checkItem(int itemID){
        try{
            return data.rentalcheckItem(itemID);
        }
        catch(SQLException e){
            
        }
        return false;
    }
    public boolean incrementQuantity(int itemID, int quantity){
        return data.rentalIncrementQuantity(itemID, quantity);
    }
    public boolean decrementQuantity(int itemID, int quantity){
        return data.rentalDecrementQuantity(itemID, quantity);
    }
    public double getPrice(int itemID){
        return data.rentalgetPrice(itemID);
    }
    public int getQuantity(int itemID){
        return data.rentalgetQuantity(itemID);
    }
    public String getDescription(int itemID){
        return data.getDescription(itemID);
    }
    public String getName(int itemID){
        return data.getName(itemID);
    }
}
