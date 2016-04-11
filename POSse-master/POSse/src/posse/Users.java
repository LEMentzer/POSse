package posse;

import java.sql.*;
public class Users {
  
  User user = null;
  private static PersistentStorage data = null;
  
  Users() throws SQLException{
    data = PersistentStorage.getInstance();
  }
  
  public void addUser(int employeeID, String password, boolean managerStatus) throws SQLException{
    //add this data and stuff to persistent storage
        data.addUser(employeeID, password, managerStatus);
    
  }
  
  void editUser(){
    //do a thing that I have not figured out yet bc I suck sorry
  }
  
  void removeUser(int id) throws SQLException{
//gui prompts for the to-be-deleted-user's ID     
//call persistent storage and write SQL query to delete it from the database :)
    data.removeUser(id);
  }
  
  public static User verifyUser(int id, String password) throws SQLException{
    boolean check = data.verifyUser(id, password);
    if(check){
      User newUser = User.getInstance(id, password,false);
      return newUser;
    }
    else{
      return null;
    }
  }
}