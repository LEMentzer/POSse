package posse;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReturnReceipt extends Receipt{
  private ArrayList<ReturnItem> returns;
  private String text;
  private double total;
  private double tax;
  private double subtotal;
  
  ReturnReceipt(ArrayList<ReturnItem> returns,double total, double tax, double subtotal){
    this.returns = returns;
    this.total = total;
    this.tax = tax;
    this.subtotal = subtotal;
    StringBuilder sb = new StringBuilder();
    String s = "Return Receipt:\n\n";
    sb.append(s);
    DecimalFormat f = new DecimalFormat("##.00");
    /*for(int i = 0; i < returns.size(); i++){
      Item item = returns.get(i).getItem();
      sb.append(item.getItemID() + "\t");
      sb.append(item.getName() + "\t");
      sb.append(returns.get(i).getQuantity() + "\t");
      sb.append("$" + f.format(returns.get(i).getTotal()));
      sb.append("\n");
    }*/
    
    for(int i = 0; i < returns.size(); i++){
      Item item = returns.get(i).getItem();
      s += String.format("%-8s", String.valueOf(item.getItemID()));
      s += String.format("%-50s", item.getName());
      s += String.format("%-6s", String.valueOf(returns.get(i).getQuantity()));
      s += ("$" + f.format(returns.get(i).getTotal()) + "\n");
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
