package posse;
import java.util.ArrayList;

public class ReturnReceipt extends Receipt{
  private ArrayList<ReturnItem> returns;
  private String text;
  private double total;
  private double tax;
  private double subtotal;
  
  SaleReceipt(ArrayList<SaleItem> returns,double total, double tax, double subtotal){
    this.returns = returns;
    this.total = total;
    this.tax = tax;
    this.subtotal = subtotal;
    text = makeText(returns);
  }
  
  private static makeText(returns){
    StringBuilder sb = new StringBuilder();
    String s = "Return Receipt:\n\n";
    sb.append(begin);
    for(int i = 0; i < returns.size(); i++){
      Item = returns.get(i).getItem();
      sb.append(item.getItemID() + "\t");
      sb.append(item.getName() + "\t");
      sb.append(returns.get(i).getQuantity());
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