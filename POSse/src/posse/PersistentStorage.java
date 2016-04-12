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
  public boolean getManagerStatus(int id) throws SQLException{
      String query = "SELECT * FROM Users WHERE ID = "+id;
    try{
      ResultSet rs = s.executeQuery(query);
      rs.next();
      int value = Integer.valueOf(rs.getString(3));
      System.out.println(value);
      if(value == 1){
          return true;
      }
      else{
          return false;
      }
    }
    catch(Exception ex){
      System.out.println(ex.getMessage() + " Incorrect");
      return false;      
    }
    
  
  }
  ////////
  public void addUser(int id, String password, boolean managerStatus) throws SQLException {
    String query = null;
        if (managerStatus == true) {
            query = "INSERT INTO Users VALUES ("+id+",1,'"+password+"');";
        }
        else {
            query = "INSERT INTO Users VALUES ("+id+",0,"+password+"');";
        }
        try {
          int i = s.executeUpdate(query);
          System.out.println("User added.");
        }
        catch (Exception ex) {
            System.out.println("User could not be added.");
        }
  }
  /////////
  public void removeUser(int id) throws SQLException{
    String query = "DELETE FROM Users where ID = " + id;
        try {
            int i = s.executeUpdate(query);
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
    String query = "update InventorySale set Quantity = " + newnum + " where UPC = " + itemID;
    try{
      s.executeUpdate(query);
      return true;
    }
    catch(SQLException ex){
      
    }
    return false;
  }
  public boolean rentalIncrementQuantity(int itemID, int quantity){
        int num = rentalgetQuantity(itemID);
        int newnum = num + quantity;
        String query = "update InventoryRental set Quantity = " + newnum + " where UPC = " + itemID;
        try{
            s.executeUpdate(query);
            return true;
        }
        catch(SQLException ex){
            
        }
        return false;
    }
  public boolean returnIncrementQuantity(int itemID, int quantity, double price){
        int num = returngetQuantity(itemID);
        if(num == -1){
            
            String query = "INSERT INTO InventoryReturn VALUES ("+itemID+","+ quantity+ ","+price+");";
            try {
              int i = s.executeUpdate(query);
              System.out.println("Return added.");
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage() + " Return could not be added.");
            }
            return false;
        }
        else{
            int newnum = num + quantity;
            String query = "update InventoryReturn set Quantity = " + newnum + " where UPC = " + itemID;
            try{
                s.executeUpdate(query);
                return true;
            }
            catch(SQLException ex){

            }
            return false;
        }
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
        int num = rentalgetQuantity(itemID);
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
      return Double.valueOf(rs.getString(3));
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
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
      return Integer.valueOf(rs.getString(1));
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
  public int returngetQuantity(int itemID){
        String query = "SELECT * FROM InventoryReturn WHERE UPC = "+itemID;
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
      System.out.println(ex.getMessage());
      return "";
    }
  }
  public String getCategory(int itemID){
      String query = "SELECT * FROM ProductDescription WHERE UPC = "+itemID;
      try{
          ResultSet rs = s.executeQuery(query);
          rs.next();
          return (rs.getString(3));
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
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
      System.out.println(ex.getMessage());
      return "";
    }
  }
}
