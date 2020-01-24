
package enterprisetester;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 *
 * @author rando
 */
public class EnterpriseTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Database db      = new Database(); // database for active products
        Database deleted = new Database(); // database for deleted products
        DateFormat df    = DateFormat.getDateInstance(DateFormat.LONG);
        Date now         = new Date();
        NumberFormat nf  = NumberFormat.getCurrencyInstance();
        boolean done     = false;
        
        
        while(!done) {
            
          int menu = GetData.getInt("\tABC ENTERPRISE\n"
                   + "\nPlease Choose From the Following:" + 
                     "\n1. Create New Product \n2. Update Existing Product "
                   + "\n3. Delete a Product"
                   + "\n4. View Product Information\n5. Exit"); 
          
          switch(menu) {
              
              case 1: // Creating Product and storing it in the database
                  System.out.println("Case 1: Storing Product");
                  // Creating Name object
                  String name = GetData.getWord("Enter Name of Product");
                  Name productName = new Name(name);
                  
                  // Creating Company & Address object
                  String businessName = GetData.getWord("Enter Company Name");
                  String street  = GetData.getWord("Enter Company Street Address");
                  String state = GetData.getWord("Enter Company State");
                  Name companyName = new Name(businessName);
                  Address addr    = new Address(street, state);
                  Manufacturer company = new Manufacturer(companyName, addr);
                  
                  // Creating Product object
                  double price    = GetData.getDouble("Enter Price");
                  int quantity    = GetData.getInt("Enter Quantity");
                  Product product = new Product(productName, company, price, quantity);
                  
                  // Add Product to database
                  db.add(product);
                  
                  break;
              case 2: // Update Product
                  System.out.println("Case 2: Update Product");
                  name = GetData.getWord("Enter name of product you want to update");
                  productName = new Name(name);
                  db.search(name);
                  if(!db.inList()) {
                      JOptionPane.showMessageDialog(null, "Product Name not found");
                  }
                  else {
                      JOptionPane.showMessageDialog(null, "Product Name found!");
                      int option = GetData.getInt("Would you like to (1) change Price, (2) Change Quantity");
                      switch(option) {
                          case 1:
                              double newPrice = GetData.getDouble("Enter new Price");
                              Product x    = db.geProduct();
                              x.changePrice(newPrice);
                              
                              break;
                          case 2:
                              int newQuantity = GetData.getInt("Enter new Quantity");
                              Product y    = db.geProduct();
                              y.changeQuantity(newQuantity);
                              
                              break;
                          default:
                              JOptionPane.showMessageDialog(null, "Invalid Selection");
                              break;
                      }
                  }
                  
                  break;
              case 3: // Delete Product
                  System.out.println("Case 3: Delete Product");
                  break;
              case 4: // View Product(s)
                  System.out.println("Case 4: View Products");
                  break;
              case 5:// Exit
                  System.out.println("Case 5: Exit");
                  done = true;
                  break;
              default:
                  JOptionPane.showMessageDialog(null, "Product Not Found");
                  break;
                  
          }
        }
        

    }
    
}
