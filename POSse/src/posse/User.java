
package posse;
import java.sql.*;

public class User {

  private int employeeID;
  private String password;
  private boolean managerStatus; // true if manager, false if cashier
  private Sale s;
  
  public User(int employeeID, String password, boolean managerStatus){
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
  
  public boolean addItem(int id, int quantity){
      try{
        return s.addItem(id, quantity);
      }
      catch(SQLException e){
          
      }
      return false;
  }
  
  public String getReceipt(){
      return s.printReceipt();
  }
  
}
