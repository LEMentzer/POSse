package posse;

 public class Payment {
   
   private boolean type; // true if credit, false if cash
   private double amount;
   // cash: amount given (includes extra change)
   // credit: amount available - set automatically equal to price when credit is selected in GUI
   private String cardNumber; // ten digits
   private String expDate;
 
   public Payment(double amount){
     // constructor for cash payment
     type = false;
     this.amount = amount;
     cardNumber = null;
     expDate = null;
   }
   
   public Payment(double amount, String cardNumber, String expDate){
     // constructor for credit payment
     type = true;
     this.amount = amount;
     this.cardNumber = cardNumber; // currently no check for lenght upon construction
     this.expDate = expDate;
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
   
   public String getExpDate() {
    /*checks that the exDate has a length of 5 with a slash in the middle and that it is
    expiring in 2016 or later
    */
    if(expDate.length() == 5 && expDate.charAt(2) == '/' && expDate.substr(3) >= "16") {
     return expDate;
    }
    else {
     return null;
    }
   }
 }
