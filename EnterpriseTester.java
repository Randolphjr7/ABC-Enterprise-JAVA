
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
                  
                  name = GetData.getWord("Delete Product - Enter Name of Product");
           
                  db.search(name);
                  if(!db.inList()) {
                      JOptionPane.showMessageDialog(null, "Product not found");
                  }
                  else {
                      JOptionPane.showMessageDialog(null, "Product found!");
                      Product z = db.geProduct();
                      int index = db.getIndex();
                      System.out.println("index of item to be deleted: " + index);
                      //db.add(db.delete(index));
                      db.delete(index);
                      deleted.add(z);
                      JOptionPane.showMessageDialog(null, "The product " + z.getName() + " has been deleted");
                  }
                  
                  break;
              case 4: // View Product(s)
                  System.out.println("Case 4: View Products");
                  
                  int view = GetData.getInt("What information would you like to view?\n 1. Single Product\n 2. All Active Products\n 3. All deleted products\n");
                  
                  switch(view) {
                      case 1: // View A single product
                          name = GetData.getWord("Please enter name of product");
                    
                          db.search(name);
                          if(!db.inList()) {
                              JOptionPane.showMessageDialog(null, "Product not found");
                          }
                          else {
                              Product f = db.geProduct();
                              String s  = "PRODUCT NAME: " + f.getName() + "\n" + "PRODUCT PRICE: " + f.getPrice() + "\n" + "QUANTITY: " + f.getQuantity() + "\n" + 
                                      "COMPANY: " + f.getCompanyName() + "\n" + "COMPANY ADDRESS: " + f.getCompanyAddress();
                              JOptionPane.showMessageDialog(null, s,  f.getName(), JOptionPane.INFORMATION_MESSAGE);
                          }
                          break;
                      case 2: // View All Active Products
                          ArrayList list = db.getList();
                          if(list.isEmpty()) {
                              JOptionPane.showMessageDialog(null, "List is empty");
                          }
                          else {
                              int i = 0, length = db.size();
                              String s = "";
                              while(i < length) {
                                  Product w = (Product) list.get(i);
                                  s += "\n PRODUCT NAME: " + w.getName() + " PRODUCT PRICE: " + nf.format(w.getPrice()) + " QUANTITY" + w.getQuantity() + 
                                      " COMPANY: " + w.getCompanyName() + " COMPANY ADDRESS: " + w.getCompanyAddress()  + "\n";
                                  i++;
                              }
                              //IO.display("Active Products", s, db.size(), JOptionPane.INFORMATION_MESSAGE);
                              display(s, "Active Products", JOptionPane.INFORMATION_MESSAGE);
                          }
                          break;
                      case 3: // View All Deleted Products
                          ArrayList closed = deleted.getList();
                          
                          if(closed.isEmpty()) {
                              JOptionPane.showMessageDialog(null, "List is empty");
                          }
                          else {
                              int i = 0 , length = closed.size();
                              String s = "";
                              while(i < length) {
                                  Product w = (Product) closed.get(i);
                                  s += "\n PRODUCT NAME: " + w.getName() + " COMPANY: " + w.getCompanyName() + nf.format(w.getQuantity()) + "\n";
                                  i++;
                              }
                              //IO.display("Delete Products", s, db.size(), JOptionPane.INFORMATION_MESSAGE);
                              display(s,"Deleted Products", JOptionPane.INFORMATION_MESSAGE);
                           }
                           break;
                       default:
                           JOptionPane.showMessageDialog(null, "Invalid Option");
                  } // End View
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
    
    static void display(String s, String heading, int MESSAGE_TYPE) {
        JTextArea text = new JTextArea(s, 40 , 60);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
    }
}
