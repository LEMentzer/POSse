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
        InventoryItem item = inv.getItem(itemID);
        if(item != null){
            return true;
        }
        return false;
    }
    
    Boolean checkQuantity(SaleItem s){
        Item i = s.getItem();
        int need = s.getQuantity();
        int id = i.getItemID();
        InventoryItem item = inv.get(id);
        int quantity = 0;
        if(item != null){
            quantity = item.getQuantity();
        }
        if(quantity >= need){
            return true;
        }
        return false;
    }
}
