package posse;
import java.sql.SQLException;

public abstract class Transaction{

  double total;
  double subtotal;
  double tax;
  String receipt;
  
  abstract AbstractItem addItem(int input, int quantity) throws SQLException;
  abstract Boolean removeItem(int input, int quantity) throws SQLException;
  abstract double calculateTotal();
  abstract double calculateSubtotal();
  abstract double calculateTax();
  abstract String printReceipt();
  
}
