package inst2002.coursework;

public class LooseProduct extends Product {

    // stores the price for 1 kilo of this product
    private final int PRICEPERKILO;

    public LooseProduct(String name, int pricePerKilo) {
        // You WILL NEED to complete this method
    	super(name);
    	PRICEPERKILO = pricePerKilo;
    }

    public int getPricePerKilo() {
        // simple getter method for quantity
        // You WILL NEED to complete this method
        return PRICEPERKILO;
    }

    public int getPrice(double weight) {
        // price of product depends on the price-per-kilo and the weight desired.
        // You WILL NEED to complete this method
        return (int) (PRICEPERKILO*weight);
    }

    public int getPostage(double weight) {
        // we must use small parcels for loose food.
        // You WILL NEED to complete this method
        return 0;
    }

    @Override
    public String toProductListEntry(int id) {
        // You SHOULD NOT edit this method, it is provided for you

        // creates a String representation of the product to place in a product list
        // input: id is the identifier of this product in some list
        String paddedName = getPaddedName();
        return String.format("%03d",id) + ": " + paddedName
            + "(per kg)\t"
            + PriceFormatter.priceToString(getPricePerKilo());
    }
    public boolean equals(LooseProduct looseProduct){
    	if(looseProduct instanceof LooseProduct){
    		if(this.getName().equals(looseProduct.getName()) && this.getPricePerKilo() == looseProduct.getPricePerKilo()){
    			return true;
    		}
    	}
    	return false;
    }
}
