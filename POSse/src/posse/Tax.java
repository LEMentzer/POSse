package posse;

class Tax{
  private double taxPercentage;
  
  Tax(double taxPercentage){
    this.taxPercentage = taxPercentage;
  }
  
  double getTax(double price){
    double tax = price * taxPercentage;
    return tax;
  }
}
