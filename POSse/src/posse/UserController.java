/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.*;
import javafx.stage.*;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author Lauren
 */
public class UserController implements Initializable {
    Users users = null;
    @FXML
    TextField newUser;
    @FXML
    TextField newPassword;
    @FXML
    TextField oldUser;
    @FXML
    Button addUser;
    @FXML
    Button deleteUser;
    @FXML 
    CheckBox manager;
    
    
    @FXML
    private void addUserAction(ActionEvent event)throws IOException, SQLException {
    
        String username = newUser.getText();
        String password = newPassword.getText();
        users.addUser(Integer.valueOf(username), password, manager.isSelected());
        
        Stage stage; 
        Parent root;
        stage=(Stage) deleteUser.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Panel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void deleteUserAction(ActionEvent event)throws IOException, SQLException {
        
        String username = oldUser.getText();
        users.removeUser(Integer.valueOf(username));
        Stage stage; 
        Parent root;
        stage=(Stage) deleteUser.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Panel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            doStuff();
        }
        catch(Exception ex){
            
        }
    }    
    
    private void doStuff() throws SQLException{
        users = new Users();
    }
}
