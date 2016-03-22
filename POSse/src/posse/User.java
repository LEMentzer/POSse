
package posse;
import java.sql.*;

public class User {

  private int employeeID;
  private String password;
  private boolean managerStatus; // true if manager, false if cashier
  private Sale s;
  private static User user = null;
  
  public static User getInstance(){
      return user;
  }
  
  public static User getInstance(int employeeID, String password, boolean managerStatus){
      user = new User(employeeID, password, managerStatus);
      return user;
  }
  private User(int employeeID, String password, boolean managerStatus){
    this.employeeID = employeeID;
    this.password = password;
    this.managerStatus = managerStatus;
    s = null;
  }
  
  public void setPassword(String newPassword){
    password = newPassword;
  }
  
  public void setManager(){
    managerStatus = true;
  }
  
  public void unsetManager(){
    managerStatus = false;
  }
  
  public int getID(){
    return employeeID;
  }
  
  public String getPassword(){
    return password;
  }
  
  public boolean isManager(){
    return managerStatus;
  }
  
  public void startSale(){
    s = new Sale();
  }
  
  public SaleItem addItem(int id, int quantity){
      try{
        return s.addItem(id, quantity);
      }
      catch(SQLException e){
          System.out.println("sql didn't work");
      }
      return null;
  }
  
  public String getReceipt(){
      return s.printReceipt();
  }
  public double getTotal(){
      return s.calculateTotal();
  }
}
