/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

import java.sql.*;


/**
 *
 * Inventory
 * 
 * Description:
 * 
 */
public class Inventory {
    
    private static Inventory inv = null;
    Connection con = null;
    
    private Inventory(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(java.lang.Exception ex){
            System.out.println(ex);
        }
        String url = "jdbc:ucanaccess://POSse.accdb";
        try{
            con = DriverManager.getConnection(url);
            System.out.println("Successful connection!");
        }
        catch(SQLException ex){
            System.out.println("Error connecting to database!");
            while(ex!=null){
                System.out.println("SQL Exception: "+ex.getMessage());
                ex = ex.getNextException();
            }
        }
        catch(java.lang.Exception ex){
            System.out.println("Unexpected error!");
        }
    }
    
    public static Inventory getInstance(){
        if (inv == null){
            inv = new Inventory();
        }
        return inv;
    }
}
