package inst2002.coursework;

public class PackagedProduct extends Product {

	// stores the price for 1 kilo of this product
    private final int UNITPRICE;
    private final double UNITWEIGHT;
    private final int MAXPERSMALLPARCEL;
    private final int MAXPERPARCEL;
    

    public PackagedProduct(String name, int unitPrice, double unitWeight, int maxPerSmallParcel, int maxPerParcel) {
        // You WILL NEED to complete this method
    	super(name);
    	UNITPRICE = unitPrice;
    	UNITWEIGHT = unitWeight;
    	MAXPERSMALLPARCEL =  maxPerSmallParcel;
    	MAXPERPARCEL = maxPerParcel;
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
    public boolean equals(PackagedProduct packagedProduct){
    	if(packagedProduct instanceof PackagedProduct){
    		if(this.getName().equals(packagedProduct.getName()) && this.getUnitPrice() == packagedProduct.getUnitPrice() && this.getUnitWeight() == packagedProduct.getUnitWeight()){
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

	public int getMaxPerSmallParcel(){
		return MAXPERSMALLPARCEL;
	}

	public int getMaxPerParcel(){
		return MAXPERPARCEL;
	}
}
