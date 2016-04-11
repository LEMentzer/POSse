/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

/**
 *
 * @author Zhuo
 */
public class RentalItem extends AbstractItem{
  private Item item;
  private int quantity;
  private double total = 0;
  
  RentalItem(Item item, int quantity, double total) {
    this.item = item;
    this.quantity = quantity;
    this.total = total;
  }
  
  Item getItem() {
    return item;
  }
  
  int getQuantity() {
    return quantity;
  }
  
  double getTotal() {
    return total;
  }
  
  void updateQuantity(int quantity) {
    this.quantity += quantity;
  }
}
