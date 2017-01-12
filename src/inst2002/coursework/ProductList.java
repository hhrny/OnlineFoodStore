package inst2002.coursework;

import java.util.List;
import java.util.ArrayList;

public class ProductList {

    private final String STORENAME;
    private List<Product> products;


    public ProductList(String storeName) {
        this.STORENAME = storeName;
        this.products = new ArrayList<Product>();
    }

    public Product getProduct(int id) {
        // You DO NOT NEED to edit this method.
        /*
           Get's product with a valid id.
preconditions: id corresponds to existing product
returns: product corresponding to the input id
*/
        if (id < products.size()) {
            return products.get(id);
        }
        throw new RuntimeException("Not a valid product id");
    }

    public boolean isProduct(int id) {
        // You DO NOT NEED to edit this method.
        /*
           Checks if id corresponds to a product
           */
        if (id >= 0 && id < products.size()) {
            return true;
        }
        return false;
    }

    public void addProduct(Product newItem) {
        // You DO NOT NEED to edit this method.
        /*
           Adds a new product to the list
preconditions: product cannot be in the list already
postconditions: product will be added to the list
*/
        if (isExistingItem(newItem))
            throw new RuntimeException(
                    "Cannot add product, it already exists");
        products.add(newItem);
    }

    public boolean isExistingItem(Product toCheck) {
        // You DO NOT NEED to edit this method.
        /*
           Checks if product is in the list
           */
        for (Product product : products) {
            if (product.equals(toCheck))
                return true;
        }
        return false;
    }

    public String toString() {
        // You DO NOT NEED to edit this method.
        /*
postcondition:
produces a String representation of the ProductList for output
*/
        String out = "\t#### Products: " + STORENAME + " ####\n\n";
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            out += product.toProductListEntry(i) + "\n";
        }
        return out;
    }

    public static ProductList createDefaultProductList() {
        // You NEED TO edit this method
        /*
           This productes a default ProductList to help you test your code. Please
           rename the store to one of your own and create your own products as needed
           */
        ProductList products = new ProductList("Luke's Exotic Foods Inc");

        /*
           You WILL NEED at least 4 packaged products, with various maximum values 
           for packing into boxes.
           */
        products.addProduct(
                new PackagedProduct("Dried Mangosteen Pack", 269, 0.13, 7, 100));

        /*
           You WILL NEED at least 3 preboxed products, some small parcels some
           non-small parcels.
           */
        products.addProduct(
                new PreboxedProduct("Organic Black Rice", 1500, 2.0, true));

        /*
           You WILL NEED at least 2 loose products at a variety of prices
           */
        products.addProduct(new LooseProduct("Star Anise", 1990));


        return products;
    }
}
