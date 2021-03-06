package posse;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SaleReceipt extends Receipt{
  private ArrayList<SaleItem> purchases;
  private String text;
  private double total;
  private double tax;
  private double subtotal;
  
  SaleReceipt(ArrayList<SaleItem> purchases,double total, double tax, double subtotal){
    this.purchases = purchases;
    this.total = total;
    this.tax = tax;
    this.subtotal = subtotal;
    StringBuilder sb = new StringBuilder();
    String s = "Sale Receipt:\n\n";
    sb.append(s);
    DecimalFormat f = new DecimalFormat("##.00");
    /*for(int i = 0; i < purchases.size(); i++){
      Item item = purchases.get(i).getItem();
      sb.append(item.getItemID() + "\t");
      sb.append(item.getName() + "\t");
      sb.append(purchases.get(i).getQuantity() + "\t");
      sb.append("$" + f.format(purchases.get(i).getTotal()));
      sb.append("\n");
    }*/
    
    for(int i = 0; i < purchases.size(); i++){
      Item item = purchases.get(i).getItem();
      s += String.format("%-8s", String.valueOf(item.getItemID()));
      s += String.format("%-50s", item.getName());
      s += String.format("%-6s", String.valueOf(purchases.get(i).getQuantity()));
      s += ("$" + f.format(purchases.get(i).getTotal()) + "\n");
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
