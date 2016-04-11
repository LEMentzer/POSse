/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posse;

import java.util.Calendar;
/**
 *
 * @author Zhuo
 */
public class RentalItem extends AbstractItem{
  private Item item;
  private int quantity;
  private double total = 0;
  private Calendar returnDate ; 
  
  RentalItem(Item item, int quantity, double total, int rentalLength) {
    this.item = item;
    this.quantity = quantity;
    this.total = total;
    this.returnDate = this.calculateReturnDate(rentalLength);
  }
  
  Calendar calculateReturnDate(int rentalLength){
      Calendar rightNow = Calendar.getInstance();
      rightNow.add(rightNow.DATE , rentalLength);
      return rightNow;
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
