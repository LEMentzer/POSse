/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

/**
 *
 * @author Lauren
 */
public abstract class AbstractItem {
    Item item;
    int quantity;
    double total;
    
    abstract Item getItem();
    abstract int getQuantity();
    abstract double getTotal();
    abstract void updateQuantity(int quantity);
}
