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
        // we can use small parcels or non-small parcels for packaged food.
        // You WILL NEED to complete this method
    	int noParcel = units / this.MAXPERPARCEL;
    	int restPrice, fullPrice;
    	double fullWeight = this.MAXPERPARCEL * this.UNITWEIGHT;
    	fullPrice = this.getPostageofWeight(fullWeight);
    	if(units % this.MAXPERPARCEL > this.MAXPERSMALLPARCEL){
    		// all are the non-small parcels
    		double restWeight = (units % this.MAXPERPARCEL) * this.UNITWEIGHT;
    		restPrice = this.getPostageofWeight(restWeight);
    		return noParcel * fullPrice + restPrice;
    	}
    	// one small parcel and others are non-small parcels
    	return noParcel * fullPrice + Product.SMALLPARCELPOSTAGE2KG;
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
    
    public boolean equals(PackagedProduct packagedProduct){
    	if(packagedProduct instanceof PackagedProduct){
    		if(this.getName().equals(packagedProduct.getName()) && this.getUnitPrice() == packagedProduct.getUnitPrice() && this.getUnitWeight() == packagedProduct.getUnitWeight()){
    			if(this.getMaxPerParcel() == packagedProduct.getMaxPerParcel() && this.getMaxPerSmallParcel() == packagedProduct.getMaxPerSmallParcel()){
        			return true;    				
    			}
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
