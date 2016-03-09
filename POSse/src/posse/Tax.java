package posse;

class Tax{
  private double taxPercentage;
  
  Tax(int taxPercentage){
    this.taxPercentage = taxPercentage;
  }
  
  double getTax(double price){
    double tax = price * taxPercentage;
    return tax;
  }
}
