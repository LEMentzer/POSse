package CSE216;
import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;

public class CSE216{
    
    public static void main(String[] args){
        //SaleSystem system = new SaleSystem;
        
        JFrame f=new JFrame("POS");
        f.setSize(500,500); 
        JPanel panel = new JPanel();
        panel.setSize(500,500);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JTextField input=new JTextField(); 
        c.weightx = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(input, c);
        
        JButton b=new JButton("Input");
        c.weightx = 2;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(b, c);
        
        JTextArea output = new JTextArea();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 5;
        c.gridwidth = 2;
        panel.add(output, c);
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = input.getText();
                try{
                    double d = Double.parseDouble(id);
                    //SOMEHOW ADD ITEM
                    output.append(id + "\n");
                    input.setText("");
                }
                catch(NumberFormatException ex){
                    
                }
                catch(NullPointerException ex){
                    
                }
            }
        });
        
        f.add(panel);
        f.setVisible(true);
    }
    
}