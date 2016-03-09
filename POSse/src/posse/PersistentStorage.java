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
public class PersistentStorage{
    
    private static PersistentStorage inv = null;
    Connection con = null;
    ResultSet result;
    Statement s;
    
    private PersistentStorage() throws SQLException{
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(java.lang.Exception ex){
            System.out.println(ex);
        }
        String url = "jdbc:ucanaccess://POSse.accdb";
        try{
            con = DriverManager.getConnection(url);
            System.out.println("Successful connection!");
            s = con.createStatement();
        }
        catch(SQLException ex){
            System.out.println("Error connecting to database!");
            while(ex!=null){
                System.out.println("SQL Exception: "+ex.getMessage());
                ex = ex.getNextException();
            }
        }
        catch(java.lang.Exception ex){
            System.out.println("Unexpected error!");
        }
    }
    
    public static PersistentStorage getInstance() throws SQLException{
        if (inv == null){
            inv = new PersistentStorage();
        }
        return inv;
    }
    public boolean verifyUser(int id, String password) throws SQLException{
        String query = "SELECT * FROM Users WHERE ID = "+id+" AND Password = "+password;
        try{
            result = s.executeQuery(query);
        }
        catch(Exception ex){
            System.out.println("Incorrect login!");
            return false;
            
        }
        System.out.println("Successful login!");
        return true;
    }
    public boolean checkItem(int itemID) throws SQLException{
        String query = "SELECT * FROM InventorySale WHERE UPC = "+itemID;
        try{
            result = s.executeQuery(query);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public boolean incrementQuantity(int itemID, int quantity){
        return true;
    }
    public boolean decrementQuantity(int itemID, int quantity){
        String query = "update InventorySale set ";
        return true;
    }
    public double getPrice(int itemID){
        return 1.1;
    }
    public int getQuantity(int itemID){
        return 1;
    }
    public String getDescription(int itemID){
        return "asdf";
    }
}
