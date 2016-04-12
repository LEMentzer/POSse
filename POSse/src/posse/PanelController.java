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
public class PanelController implements Initializable {
    User user;
    
    @FXML
    Button saleButton;
    
    @FXML
    private void saleAction(ActionEvent event)throws IOException{
        Stage stage; 
        Parent root;
        stage=(Stage) saleButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        user.startSale();
    }
    
    @FXML
    private void rentalAction(ActionEvent event)throws IOException{
        Stage stage; 
        Parent root;
        stage=(Stage) saleButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Rental.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        user.startRental();
    }
    
    @FXML
    private void returnAction(ActionEvent event)throws IOException{
        Stage stage; 
        Parent root;
        stage=(Stage) saleButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Return.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        user.startReturn();
    }
    
    @FXML
    private void usersAction(ActionEvent event)throws IOException{
        
        if(user.isManager()){
            Stage stage; 
            Parent root;
            stage=(Stage) saleButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("User.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        //user.startUsers();
    }
    
    @FXML
    private void logoutAction(ActionEvent event)throws IOException{
        //user.logout();
        user = null;
        Stage stage; 
        Parent root;
        stage=(Stage) saleButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = User.getInstance();
    }    
    
}
