package inst2002.coursework;

public class PreboxedProduct extends Product {

	// stores the price for 1 kilo of this product
    private final int UNITPRICE;
    private final double UNITWEIGHT;
    private boolean inSmallParcel;

    public PreboxedProduct(String name, int unitPrice, double unitWeight, boolean inSmallParcel) {
        // You WILL NEED to complete this method
    	super(name);
    	UNITPRICE = unitPrice;
    	UNITWEIGHT = unitWeight;
    	this.inSmallParcel = inSmallParcel;
    }

    public int getPrice(int units) {
        // price of product depends on the price-per-kilo and the weight desired.
        // You WILL NEED to complete this method
        return UNITPRICE*units;
    }

    public int getPostage(int units) {
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
            + "(" + String.format("%.2d", getUnitWeight()) + ")\t"
            + PriceFormatter.priceToString(getUnitPrice());
    }
    public boolean equals(PreboxedProduct preboxedProduct){
    	if(preboxedProduct instanceof PreboxedProduct){
    		if(this.getName().equals(preboxedProduct.getName()) && this.getUnitPrice() == preboxedProduct.getUnitPrice() && this.getUnitWeight() == preboxedProduct.getUnitWeight()){
    			return true;
    		}
    	}
    	return false;
    }

	public int getUnitPrice() {
		return UNITPRICE;
	}

	public double getUnitWeight() {
		return UNITWEIGHT;
	}

	public boolean inSmallParcel(){
		return inSmallParcel;
	}
}
