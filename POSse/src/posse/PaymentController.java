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
public class PaymentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    User user = null;
    Payment payment = null;
    double amount;
    @FXML
    Label total;
    @FXML
    Button paidButton;
    @FXML
    TextField card;
    @FXML
    TextField date;
    @FXML
    Button submit;
    
    
    @FXML
    private void paidAction(ActionEvent event)throws IOException{
        payment = new Payment(amount);
        Stage stage; 
        Parent root;
        stage=(Stage) paidButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Panel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void submitAction(ActionEvent event)throws IOException{
        payment = new Payment(amount, card.getText(), date.getText());
        if(payment.getCardNumber() == null){
            card.setText("");
            date.setText("");
        }
        else if(payment.getExpDate() == null){
            card.setText("");
            date.setText("");
        }
        else{
            Stage stage; 
            Parent root;
            stage=(Stage) submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Panel.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = User.getInstance();
        amount = user.getTotal();
        //payment = new Payment(amount);
        total.setText("Total: $" + amount);
    }    
    
}
