
package enterprisetester;

/**
 *
 * @author rando
 */
public class Product {
    
    private Name name;
    private Manufacturer company;
    private double price;
    private int quantity;
    
    
    public Product(Name name, Manufacturer company, double price, int quantity) {
        this.name     = name;
        this.company  = company;
        this.price    = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        String productName = name.getName();
        return productName;
    }
    
    public String getCompanyName() {
        String manufacturer = company.getName();
        return manufacturer;
    }
    
    
    public String getCompanyAddress() {
        String companyAddress = company.getAddress();
        return companyAddress;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void changePrice(double newPrice) {
        price = newPrice;
    }
    
    public void changeQuantity(int newQuantity) {
        quantity = newQuantity;
    }
    
    public void makeSale(int orderQuantity) {
        quantity -= orderQuantity;
    }
    
    public void placeOrder(int orderQuantity) {
        quantity += orderQuantity;
    }
    
    
}
