package posse;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *
 * ItemScanner
 * 
 * Description:
 * 
 * 
 */
public class ItemScanner {
    private Inventory inv;
    
    ItemScanner(Inventory in){
        inv = in;
    }
    
    Boolean checkItem(int itemID){
        int quantity = inv.getQuantity(itemID);
        if(quantity != -1){
            return true;
        }
        return false;
    }
    
    Boolean checkQuantity(SaleItem s){
        Item i = s.getItem();
        int need = s.getQuantity();
        int id = i.getItemID();
        int quantity = inv.getQuantity(id);
        if(quantity >= need){
            return true;
        }
        return false;
    }
}
