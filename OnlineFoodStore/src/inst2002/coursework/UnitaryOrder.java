package inst2002.coursework;

public class UnitaryOrder implements BasketItem {
    // You NEED TO complete this class to implement the BasketItem interface

	private int units;
	private final Product PRODUCT;
	
	public UnitaryOrder(Product product, String quantityStr){
		this.PRODUCT = product;
		amendOrder(quantityStr);
	}
	
    public String toString() {
        // You DO NOT NEED to edit this method.
        return PriceFormatter.priceToString(orderPrice()) + "\t" + units + "unit "
            + PRODUCT.getName();
    }
	
	@Override
	public int orderPrice() {
		// TODO Auto-generated method stub
		if(this.PRODUCT instanceof PreboxedProduct){
			return ((PreboxedProduct)(this.PRODUCT)).getPrice(this.units);
		}
		else if(this.PRODUCT instanceof PackagedProduct){
			return ((PackagedProduct)(this.PRODUCT)).getPrice(this.units);
		}
		else{
			System.out.println("product is either PreboxedProduct or PackagedProduct!");
			return 0;
		}
	}

	@Override
	public int postagePrice() {
		// TODO Auto-generated method stub
		if(this.PRODUCT instanceof PreboxedProduct){
			return ((PreboxedProduct)(this.PRODUCT)).getPostage(this.units);
		}
		else if(this.PRODUCT instanceof PackagedProduct){
			return ((PackagedProduct)(this.PRODUCT)).getPostage(this.units);
		}
		else{
			System.out.println("product is either PreboxedProduct or PackagedProduct!");
			return 0;
		}
	}

	@Override
	public boolean matchesProduct(Product product) {
		// TODO Auto-generated method stub
		if(this.PRODUCT.equals(product)){
			return true;
		}
		return false;
	}

	@Override
	public void amendOrder(String quantityStr) {
		// TODO Auto-generated method stub
		this.units = Integer.parseInt(quantityStr);
	}

}
