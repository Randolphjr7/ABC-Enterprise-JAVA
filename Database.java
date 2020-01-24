
package enterprisetester;

import java.util.ArrayList;

/**
 *
 * @author rando
 */
public class Database {
    
    ArrayList<Product> list;
    Product item;
    int index;
    boolean found;

    public Database() {
        list = new ArrayList<Product>();
    }
    
    void search(String key) {
        found = false;
        int i = 0;
        
        while(!found && i < list.size()) {
            Product b = list.get(i);
            if(b.getName().equalsIgnoreCase(key)) {
                item = b;
                found = true;
                index = i;
            }
            else{
                i++;
            }
        }
    }
    
    void add(Product b) {
        list.add(b);
    }
    
    Product delete(int i) {
        return list.remove(i);
    }
    
    int getIndex() {
        return index;
    }
    
    boolean inList() {
        return found;
    }
    
    Product geProduct() {
        return item;
    }
    
    int size() {
        return list.size();
    }
    
    boolean isEmpty() {
        return list.isEmpty();
    }
    
    ArrayList getList() {
        return list;
    }
}
