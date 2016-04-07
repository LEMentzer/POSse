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
public class ReturnController implements Initializable {

    User user;
    Inventory inv;
    
    @FXML
    private Label userID;
    @FXML
    private TextField itemID;
    @FXML
    private TextField quantity;
    @FXML
    private Button add;
    @FXML
    private Button complete;
    @FXML
    private TextField subtotal;
    @FXML
    private TextArea sale;
    
    
    @FXML
    private void addButtonAction(ActionEvent event)throws IOException, SQLException {
        String id = itemID.getText();
        String num = quantity.getText();
        System.out.println(id + " " + num);
        
        try{
            int i1 = Integer.parseInt(id);
            int i2 = Integer.parseInt(num);

            ReturnItem item = user.addReturnItem(i1, i2);
            itemID.setText("");
            quantity.setText("");
            
            sale.appendText(id + "\t" + item.getItem().getName() + "\t" + num + "\t" + item.getTotal() + "\n");
        }
        catch(NumberFormatException ex){

        }
        
    }
    
    @FXML
    private void completeButtonAction(ActionEvent event)throws IOException, SQLException {
        subtotal.setText(String.valueOf(user.getReturnTotal()));
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        user = User.getInstance();
        int id = user.getID();
        userID.setText("Cashier ID: " + id);
        try{
            inv = new Inventory();
        }
        catch(Exception e){}
    }    
}
