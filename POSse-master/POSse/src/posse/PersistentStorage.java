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
  ////////
  public void addUser(int id, String password, boolean managerStatus) throws SQLException {
    String query = "insert into Users values ("+id+", "+password+", "+managerStatus+");";
    try {
      result = s.executeQuery(query);
      System.out.println("User added.");
    }
    catch (Exception ex) {
      System.out.println("User could not be added.");
    }
  }
  /////////
  public void removeUser(int id) throws SQLException{
    String query = "delete from Users where ID = " + id + ";";
    try {
      result = s.executeQuery(query);
      System.out.println("User deleted.");
    }
    catch(Exception ex) {
      System.out.println("User could not be deleted.");
    }
  }
  
  public boolean checkItem(int itemID) throws SQLException{
    String query = "SELECT * FROM InventorySale WHERE UPC = "+itemID;
    try{
      result = s.executeQuery(query);
      if(result != null){
        return true;
      }
      return false;
    }
    catch(Exception ex){
      return false;
    }
  }
  public boolean rentalcheckItem(int itemID) throws SQLException{
        String query = "SELECT * FROM InventoryRental WHERE UPC = "+itemID;
        try{
            result = s.executeQuery(query);
            if(result != null){
                return true;
            }
            return false;
        }
        catch(Exception ex){
            return false;
        }
    }
  public boolean incrementQuantity(int itemID, int quantity){
    int num = getQuantity(itemID);
    int newnum = num + quantity;
    String query = "update InventorySale set Quantity-on-Hand = " + newnum + " where UPC = " + itemID;
    try{
      s.executeUpdate(query);
      return true;
    }
    catch(SQLException ex){
      
    }
    return false;
  }
  public boolean rentalIncrementQuantity(int itemID, int quantity){
        int num = getQuantity(itemID);
        int newnum = num + quantity;
        String query = "update InventoryRental set Quantity-on-Hand = " + newnum + " where UPC = " + itemID;
        try{
            s.executeUpdate(query);
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
  public boolean decrementQuantity(int itemID, int quantity){
    int num = getQuantity(itemID);
    int newnum = num - quantity;
    String query = "update InventorySale set Quantity = " + newnum + " where UPC = " + itemID;
    try{
      s.executeUpdate(query);
      return true;
    }
    catch(SQLException ex){
      
    }
    return false;
  }
  public boolean rentalDecrementQuantity(int itemID, int quantity){
        int num = getQuantity(itemID);
        int newnum = num - quantity;
        String query = "update InventoryRental set Quantity = " + newnum + " where UPC = " + itemID;
        try{
            s.executeUpdate(query);
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
  public double getPrice(int itemID){
    String query = "SELECT * FROM InventorySale WHERE UPC = "+itemID;
    try{
      ResultSet rs = s.executeQuery(query);
      rs.next();
      return Double.valueOf(rs.getString(4));
    }
    catch(Exception ex){
      return -1;
    }
  }
  public double rentalgetPrice(int itemID){
        String query = "SELECT * FROM InventoryRental WHERE UPC = "+itemID;
        try{
            ResultSet rs = s.executeQuery(query);
            rs.next();
            return Double.valueOf(rs.getString(4));
        }
        catch(Exception ex){
            return -1;
        }
    }
  public int getQuantity(int itemID){
    String query = "SELECT * FROM InventorySale WHERE UPC = "+itemID;
    try{
      ResultSet rs = s.executeQuery(query);
      rs.next();
      return Integer.valueOf(rs.getString(2));
    }
    catch(Exception ex){
      return -1;
    }
  }
  public int rentalgetQuantity(int itemID){
        String query = "SELECT * FROM InventoryRental WHERE UPC = "+itemID;
        try{
            ResultSet rs = s.executeQuery(query);
            rs.next();
            return Integer.valueOf(rs.getString(2));
        }
        catch(Exception ex){
            return -1;
        }
    }
  public String getDescription(int itemID){
    String query = "SELECT * FROM ProductDescription WHERE UPC = "+itemID;
    try{
      ResultSet rs = s.executeQuery(query);
      rs.next();
      return (rs.getString(2));
    }
    catch(Exception ex){
      return "";
    }
  }
  public String getName(int itemID){
    String query = "SELECT * FROM ProductDescription WHERE UPC = "+itemID;
    try{
      ResultSet rs = s.executeQuery(query);
      rs.next();
      return (rs.getString(3));
    }
    catch(Exception ex){
      return "";
    }
  }
}