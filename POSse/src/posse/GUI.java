package posse;

import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * GUI
 * 
 * Description:
 * 
 * 
 */
public class GUI {
    User user = null;
    private static GUI gui = null;
    
    public static GUI getInstance() throws SQLException{
        if(gui == null){
            gui = new GUI();
        }
        return gui;
    }
    
    private GUI() throws SQLException{
        Users users = new Users();
        Inventory inv = new Inventory();
        JFrame f=new JFrame("POS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800); 
        
        JPanel panel1 = new JPanel();
        panel1.setSize(800,800);
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel usernameLabel = new JLabel("Username"); 
        JTextField username=new JTextField(); 
        c.insets = new Insets(20, 20, 20, 20);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        panel1.add(usernameLabel, c);
        c.weightx = 4;
        panel1.add(username, c);
        
        JLabel passLabel = new JLabel("Password"); 
        JTextField password=new JTextField(); 
        c.weightx = 1;
        panel1.add(passLabel, c);
        c.weightx = 4;
        panel1.add(password, c);
        
        JButton button=new JButton("Login");
        c.weightx = 1;
        panel1.add(button, c);
        

        f.add(panel1);
        
        
 
        
        JPanel panel = new JPanel();
        panel.setSize(800,800);
        panel.setLayout(new GridBagLayout());
        
        JLabel idLabel = new JLabel("Item ID"); 
        JTextField input=new JTextField(); 
        c.insets = new Insets(20, 20, 20, 20);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(idLabel, c);
        c.weightx = 4;
        panel.add(input, c);
        
        JLabel quantityLabel = new JLabel("Quantity"); 
        JTextField quantity=new JTextField(); 
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(quantityLabel, c);
        c.weightx = 2;
        panel.add(quantity, c);
        
        JButton b=new JButton("Add");
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(b, c);
        
        
        JButton done=new JButton("Complete");
        c.weightx = 1;
        c.weighty = 1;
        c.gridy = 1;
        panel.add(done, c);
        
        JTextArea output = new JTextArea();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 10;
        c.gridwidth = 5;
        panel.add(output, c);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String i = username.getText();
                int idnum = Integer.parseInt(i);
                String pass = password.getText();
                try{
                    user = Users.verifyUser(idnum, pass);
                    if(user != null){
                        f.remove(panel1);
                        f.add(panel);
                        f.validate();
                        f.repaint();
                    }
                    else{
                        username.setText("");
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
        });
        
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = input.getText();
                String num = quantity.getText();
                System.out.println(id + " " + num);
                System.out.println(user.getID());
                try{
                    int i1 = Integer.parseInt(id);
                    int i2 = Integer.parseInt(num);
                    
                    System.out.println(user.addItem(i1, i2));
                    //output.append(id + "\n");
                    input.setText("");
                }
                catch(NumberFormatException ex){
                    
                }
                catch(NullPointerException ex){
                    System.out.println("something is null");
                }
            }
        });
        
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try{
                    String receipt = user.getReceipt();
                    output.append(receipt);
                    
                }
                catch(NumberFormatException ex){
                    
                }
                catch(NullPointerException ex){
                    
                }
            }
        });
        
        
        //f.add(panel);
        f.setVisible(true);
    }
}
