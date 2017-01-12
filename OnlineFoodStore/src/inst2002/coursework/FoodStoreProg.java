package inst2002.coursework;

import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class FoodStoreProg {

    private ProductList productList;
    private Basket basket;
    private static Scanner scan;

    public FoodStoreProg() {
        // You SHOULD NOT edit this method
        scan = new Scanner(System.in);
        productList = ProductList.createDefaultProductList();
    }

    public static void main(String[] args) {
        // You should uncomment parts of this method as needed
        FoodStoreProg fs = new FoodStoreProg();

        /*
           use this to test your ProductList class and related classes
           */
        fs.printProductList();

        /*
           use this to test the full programme including the Basket class and related
           classes.
           */
        // uncomment the line below when you start to implement the classes from 
        // section 4 of the assessment
        fs.run();

    }

    public void printProductList() {
        // You SHOULD NOT edit this method
        System.out.println(productList);
    }

    // uncomment the methods below when you start to implement the classes from
    // section 4 of the assessment

    public void run() {
	    // You SHOULD NOT edit this method
	    basket = new Basket();
	
	    String selection = "";
	    while (true) {
	    // output product list, current status and request input
	    System.out.println(productList);
	    System.out.println(basket);
	    System.out.print("Input product id, or x to exit and pay: ");
	    selection = scan.next();
	    // user chooses to exit and pay
	    if (selection.toLowerCase().equals("x")) {
	    break;        
	    }
	    try {
	    // try to parse user input as a product id
	    int productId = Integer.parseInt(selection);
	    if (productList.isProduct(productId)) {
	    Product product = productList.getProduct(productId);
	    if (basket.inBasket(product)) {
	    requestAmendOrder(product);
	    } else {
	    requestAddNewOrder(product);
	    }
	    } else {
	    // product id not in list
	    throw new IllegalArgumentException();
	    }
	    } catch (IllegalArgumentException e) {
	    System.out.println("Unrecognised selection. Please try again.\n\n");
	    }
	    }
	
	    finalise();
	       }
	
	       public void requestAddNewOrder(Product item) {
	    // You SHOULD NOT edit this method
	    // Customer has requested an item not already in the basket.
	    // This method elicits the desired quantity of that product then adds it to 
	    // the basket.
	    System.out.println("Adding: " + item.getName() );
	    System.out.print("Input the desired quantity: ");
	    String quantityStr = scan.next();
	    try {
	    basket.addNewOrder(item, quantityStr);
	    } catch (IllegalArgumentException e) {
	    System.out.println("Your input was not recognised."
	    + " Your item has not been added.");
	    }
    }

       public void requestAmendOrder(Product item) {
    // You SHOULD NOT edit this method
    // Customer has requested an item already in the basket.
    //  This elicits the desired change in quantity for that product then
    //  updates the basket accordingly.
    System.out.println("Amending: " + item.getName() );
    System.out.print("Input the new desired quantity: ");
    String quantityStr = scan.next();
    try {
    basket.amendOrder(item, quantityStr);
    } catch (IllegalArgumentException e) {
    System.out.println("Your input was not recognised."
    + " We were unable to amend your order");
    }
       }


    public void finalise() {
        // You SHOULD NOT edit this method
        // Prints out the final order when the customer has finished. 
        System.out.println( "\n" + basket);
        System.out.println("This is your final order, please pay at counter.\n");
    }
    
}
