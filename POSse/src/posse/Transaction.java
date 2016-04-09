package posse;
import java.sql.SQLException;

public abstract class Transaction{

  double total;
  double subtotal;
  double tax;
  String receipt;
  
  abstract Boolean addItem(int input, int quantity);
  abstract Boolean removeItem(int input, int quantity);
  abstract double calculateTotal();
  abstract double calculate subtotal();
  abstract double calculateTax();
  abstract String printReceipt();
  
}