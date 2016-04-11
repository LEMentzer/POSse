
package posse;

public class Payment {
  
  private boolean type; // true if credit, false if cash
  private double amount;
  // cash: amount given (includes extra change)
  // credit: amount available - set automatically equal to price when credit is selected in GUI
  private String cardNumber; // ten digits

  public Payment(double amount){
    // constructor for cash payment
    type = false;
    this.amount = amount;
    cardNumber = null;
  }
  
  public Payment(double amount, String cardNumber){
    // constructor for credit payment
    type = true;
    this.amount = amount;
    this.cardNumber = cardNumber; // currently no check for lenght upon construction
  }
  
  public boolean isCredit(){
    return type;
  }
  
  public double getAmount(){
    return amount;
  }
  
  public String getCardNumber(){
    if(cardNumber.length() == 10){
      return cardNumber; // verify proper length of card number
    } else {
      return null; // return null if cash type or improper card number format
    }
  }
  
}
