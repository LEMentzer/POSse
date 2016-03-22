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
 *
 * @author Lauren
 */
public class LoginController implements Initializable {
    User user;

    
    @FXML
    private TextField id;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event)throws IOException, SQLException {
        Stage stage; 
        Parent root;
        doStuff();
        
        String i = id.getText();
        int idnum = Integer.parseInt(i);
        String pass = password.getText();
        
        try{
            System.out.println(idnum + " " + pass);
            user = Users.verifyUser(idnum, pass);
            if(user != null){
                stage=(Stage) login.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                user.startSale();
            }
            else{
                id.setText("");
                password.setText("");
            }
        }
        catch(NumberFormatException ex){

        }
        catch(NullPointerException ex){
            System.out.println("something is null");
        }
        catch(SQLException ex){
            System.out.println("sql didn't work");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
       
    }    
    

    private void doStuff() throws SQLException{
        Users users = new Users();
        Inventory inv = new Inventory();
    }
    
}
