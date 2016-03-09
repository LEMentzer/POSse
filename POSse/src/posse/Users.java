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
public class Users {
    private static PersistentStorage data = null;
    Users(){
        data = PersistentStorage.getInstance();
    }
    void addUser(){
        
    }
    void editUser(){
        
    }
    void removeUser(){
        
    }
    public static User verifyUser(int id, String password){
        boolean check = data.verifyUser(id, password);
        if(check){
            User newUser = new User(id, password);
            return newUser;
        }
        else{
            return null;
        }
    }
}
