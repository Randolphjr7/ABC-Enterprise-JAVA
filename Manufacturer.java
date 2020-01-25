
package enterprisetester;

/**
 *
 * @author rando
 */
public class Manufacturer {
    
    private Name name;
    private Address address;
    
    public Manufacturer(Name name, String street, String state) {
        this.name       = name;
        Address address = new Address(street, state);
    }
    
    public Manufacturer(Name name, Address address) {
        this.name    = name;
        this.address = address;
    }
    
    public String getName() {
        String companyName = name.getName();
        return companyName;
    }
    
    public String getAddress() {
        String companyAddress = address.getAddress();
        return companyAddress;
    }
}
