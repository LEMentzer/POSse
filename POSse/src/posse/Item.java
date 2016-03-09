package posse;

class Item {
  private int itemID;
  private String name;
  private double price;
  private boolean taxable;
  
  Item(int itemID, String name, double price, boolean taxable) {
    this.itemID = itemID;
    this.name = name;
    this.price = price;
    this.taxable = taxable;
  }
   
  int getItemID() {
    return itemID;
  }
  
  String getName() {
    return name;
  }
  
  double getPrice() {
    return price;
  }
  
  boolean getTaxable() {
    return taxable;
  }
  
  int equals(Item item) {
    if(item.getItemID() < itemID) {
      return -1;
    }
    else if(item.getItemID() > itemID) {
      return 1;
    }
    else {
      return 0;
    }
  }
  
  
}
  