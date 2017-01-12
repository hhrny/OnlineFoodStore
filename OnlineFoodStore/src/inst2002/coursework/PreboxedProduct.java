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
        // we can use small parcels or non-small parcels for preboxed food.
        // You WILL NEED to complete this method
    	int result;
    	if(this.inSmallParcel){
    		// the preboxed product deliver using small parcel
        	int unitNumPerSmallParcel = (int) (2.0 / this.UNITWEIGHT);    // get the number of units per small parcel, 2.0kg
        	result = units / unitNumPerSmallParcel;
        	if(units % unitNumPerSmallParcel > 0){
        		result ++;
        	}
        	return result * Product.SMALLPARCELPOSTAGE2KG;
        }
    	// deliver using non-small parcel
		int unitNumPerParcel = (int) (20.0 / this.UNITWEIGHT);    // get the number of units per parcel, 20.0kg
		result = units / unitNumPerParcel;                        // the number of full parcel
		double restWeight = (units % unitNumPerParcel) * this.UNITWEIGHT;  // the rest weight in no full parcel
		int restPrice = this.getPostageofWeight(restWeight);
		return result*Product.PARCELPOSTAGE20KG + restPrice;
    }
    
    public int getPostageofWeight(double weight){
    	if(weight > 20.0){
    		System.out.println("error: weight bigger than 20.0");
    		return 0;
    	}
    	else if(weight > 10.0){
    		return Product.PARCELPOSTAGE20KG;
    	}
    	else if(weight > 5.0){
    		return Product.PARCELPOSTAGE10KG;
    	}
    	else if(weight > 2.0){
    		return Product.PARCELPOSTAGE5KG;
    	}
    	else if(weight > 0.0){
    		return Product.PARCELPOSTAGE2KG;
    	}
    	else{
    		System.out.println("error: weight less than 0.0");
    		return -1;
    	}
    }

    @Override
    public String toProductListEntry(int id) {
        // creates a String representation of the product to place in a product list
        // input: id is the identifier of this product in some list
        String paddedName = getPaddedName();
        return String.format("%03d",id) + ": " + paddedName
            + "(" + String.format("%.2f", getUnitWeight()) + ")\t"
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
