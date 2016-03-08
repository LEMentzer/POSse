package POSse;
import java.util.ArrayList;

class Cart{
  private int numItems;
  private ArrayList<Item> items;
  
  Cart(){
    items = new ArrayList<item>();
    numItems = 0;
  }
  
  void addToCart(Item i){
    cart.add(i);
  }
  
  Item getItem(int n){
    return cart.get(n);
  }
  
  /*Modified version of quick sort method from a textbook*/
  void sortCart(){
    sortCart(cart,0,numIitems-1);
  }
  
  static void sortCart(ArrayList<Item> list, int first, int last){
    if (last > first){
      int pivotIndex = partition(list,first,last);
      sortCart(list,first,pivotIndex-1);
      sortCart(list,pivotIndex+1,last);
    }
  }
  
  static int partition(ArrayList<Item>, int first, int last){
    Item pivot = list.get(first);
    int low = first + 1;
    int high = last;
    
    while (highn > low) {
      while (high <= high && (list.get(low).equals(pivot) != -1)) low++;
      while (low <= high && (list.get(high).equals(pivot) == -1)) high--;
      
      if (high > low){
        Item temp = list.get(high);
        list.set(high,list.get(low));
        list.set(low,temp);
      }
    }
    
    while (high > first && (list.get(high).equals(pivot) != 1)) high--;
    
    if (pivot.equals(list.get(high)) == -1){
      list.set(first,list.get(high));
      list.set(high,pivot);
      return high;
    }
    
    else return first;
  }
}