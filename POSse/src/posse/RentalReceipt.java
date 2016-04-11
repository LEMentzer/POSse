package posse;
import java.util.ArrayList;

public class RentalReceipt extends Receipt{
  private ArrayList<RentalItem> rentals;
  private String text;
  private double total;
  private double tax;
  private double subtotal;
  
  SaleReceipt(ArrayList<RentalItem> rentals, double total, double tax, double subtotal){
    this.rentals = rentals;
    this.total = total;
    this.tax = tax;
    this.subtotal = subtotal;
    text = makeText(rentals);
  }
  
  private static makeText(rentals){
    StringBuilder sb = new StringBuilder();
    String s = "Rental Receipt:\n\n";
    sb.append(begin);
    for(int i = 0; i < rentals.size(); i++){
      Item = rentals.get(i).getItem();
      sb.append(item.getItemID() + "\t");
      sb.append(item.getName() + "\t");
      sb.append(rentals.get(i).getQuantity());
      sb.append(rentals.get(i).getReturnDate());
    }
    
    text = sb.toString();
    
    text += ("\n\nSubtotal: " + "$" + subtotal);
    text += ("\nTax: " + "$" + tax);
    text += ("\nTotal: " + "$" + total);
  }
  
  public String getText(){
    return text;
  }
}