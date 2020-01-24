
package enterprisetester;

/**
 *
 * @author rando
 */
public class Name {
    
    private String name;
    
    public Name(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void changeName(String newName) {
        this.name = newName;
    }
    
}
