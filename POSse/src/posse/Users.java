/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

/**
 *
 * @author Lauren
 */
import java.sql.*;
public class Users {
    private static PersistentStorage data = null;
    Users() throws SQLException{
        data = PersistentStorage.getInstance();
    }
    void addUser(){
        
    }
    void editUser(){
        
    }
    void removeUser(){
        
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
