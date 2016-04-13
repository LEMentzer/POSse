
package posse;
import java.sql.*;

public class User {

  private int employeeID;
  private String password;
  private boolean managerStatus; // true if manager, false if cashier
  private Transaction t;
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
    t = null;
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
    t = new Sale();
  }
  
  public void startRental(){
    t = new Rental();
  }
  
  public void startReturn(){
    t = new Returns();
  }
  
  public AbstractItem addItem(int id, int quantity){
      try{
        return t.addItem(id, quantity);
      }
      catch(SQLException e){
          System.out.println("sql didn't work");
      }
      return null;
  }
  public AbstractItem addRentalReturnItem(int id, int quantity){
      try{
        return ((Returns)t).addRentalItem(id, quantity);
      }
      catch(SQLException e){
          System.out.println("sql didn't work");
      }
      return null;
  }
  public String getReceipt(){
    Receipt r = t.printReceipt();
    return r.getText();
  }
  public double getTotal(){
      return t.calculateTotal();
  }
}
