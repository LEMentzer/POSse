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
import java.text.DecimalFormat;
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

            AbstractItem item = user.addItem(i1, i2);
            itemID.setText("");
            quantity.setText("");
            
            
            DecimalFormat f = new DecimalFormat("##.00");
            if(item != null) {
                sale.appendText(id + "\t" + item.getItem().getName() + "\t" + num + "\t" + f.format(item.getTotal()) + "\n");
            }
        }
        catch(NumberFormatException ex){

        }
        
        System.out.println("here toooo");
        DecimalFormat f = new DecimalFormat("##.00");
        subtotal.setText(String.valueOf(f.format(user.getTotal())));
    }
    
    @FXML
    private void completeButtonAction(ActionEvent event)throws IOException, SQLException {
        subtotal.setText(String.valueOf(user.getTotal()));
        
        Stage stage; 
        Parent root;
        stage=(Stage) complete.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
