
package enterprisetester;

/**
 *
 * @author rando
 */
public class Address {
    
    private String street, city, state, zip;
    
    public Address(String street, String city, String state, String zip) {
        this.street  = street;
        this.city    = city;
        this.state   = state;
        this.zip     = zip;
    }
    
    public Address(String street, String state) {
        this.street = street;
        this.state  = state;
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZip() {
        return zip;
    }
    
    public String getFullAddress() {
        String fullAddresss;
        return fullAddresss = getStreet()+ " " + getCity() + ", " + getState();
    }
    
    public String getAddress() {
        String addy;
        return addy = getStreet() + ", " + getState();
    }
    
    public void changeStreet(String newStreet) {
        this.street = newStreet;
    }
    
    public void changeCity(String newCity) {
        this.city = newCity;
    }
    
    public void changeState(String newState) {
        this.state = newState;
    }
    
    public void changeZip(String newZip) {
        this.zip = newZip;
    }
}
