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
public class ReturnPanelController implements Initializable {
    @FXML
    Button salebutton;
    @FXML
    Button returnbutton;
    
    
     @FXML
    private void saleReturnAction(ActionEvent event)throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) salebutton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Return.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    private void rentalReturnAction(ActionEvent event)throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) salebutton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ReturnRental.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
