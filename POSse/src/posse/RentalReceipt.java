package posse;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class RentalReceipt extends Receipt{
  private ArrayList<RentalItem> rentals;
  private String text;
  private double total;
  private double tax;
  private double subtotal;
  
  RentalReceipt(ArrayList<RentalItem> rentals, double total, double tax, double subtotal){
    this.rentals = rentals;
    this.total = total;
    this.tax = tax;
    this.subtotal = subtotal;
    //StringBuilder sb = new StringBuilder();
    String s = "Rental Receipt:\n\n";
    //sb.append(s);
    DecimalFormat f = new DecimalFormat("##.00");
    /*for(int i = 0; i < rentals.size(); i++){
      Item item = rentals.get(i).getItem();
      sb.append(item.getItemID() + "\t");
      sb.append(item.getName() + "\t");
      sb.append(rentals.get(i).getQuantity() + "\t");
      sb.append("\n\t Security Deposit: $" + f.format(rentals.get(i).getItem().getPrice()));
      sb.append("\n\t Subtotal: $" + f.format(rentals.get(i).getTotal()));
      sb.append("\n\t Return by: " + rentals.get(i).getReturnDate());
      sb.append("\n");
    }
    
    text = sb.toString();
    
    text += ("\n\nSubtotal: " + "$" + f.format(subtotal));
    text += ("\nTax: " + "$" + f.format(tax));
    text += ("\nTotal: " + "$" + f.format(total));*/
    
    for(int i = 0; i < rentals.size(); i++){
      Item item = rentals.get(i).getItem();
      s += String.format("%-8s", String.valueOf(item.getItemID()));
      s += String.format("%-50s", item.getName());
      s += String.format("%-6s", String.valueOf(rentals.get(i).getQuantity()));
      s += ("\n\t Security Deposit: $" + f.format(rentals.get(i).getItem().getPrice()));
      s += ("\n\t Subtotal: $" + f.format(rentals.get(i).getTotal()));
      s += ("\n\t Return by: " + rentals.get(i).getReturnDate() + "\n");
    }
    
    text = s + "\n\n";
    text += ("\n\nSubtotal: " + "$" + f.format(subtotal));
    text += ("\nTax: " + "$" + f.format(tax));
    text += ("\nTotal: " + "$" + f.format(total));
  }
  
  public String getText(){
    return text;
  }
}
