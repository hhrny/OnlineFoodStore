package inst2002.coursework;

import java.lang.IllegalArgumentException;

public class WeightOrder implements BasketItem{
    // You NEED TO complete this class to implement the BasketItem interface

    private double weight;
    private final LooseProduct PRODUCT;

    public WeightOrder(LooseProduct product, String quantityStr) {
        // You DO NOT NEED to edit this method.
        this.PRODUCT = product;
        amendOrder(quantityStr);
    }

	public double getWeight() {
        // You DO NOT NEED to edit this method.
        return weight;
    }

    public String toString() {
        // You DO NOT NEED to edit this method.
        return PriceFormatter.priceToString(orderPrice()) + "\t" + weight + "kg "
            + PRODUCT.getName();
    }

	@Override
	public int postagePrice() {
		// TODO Auto-generated method stub
		return this.PRODUCT.getPostage(this.weight);
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
	public int orderPrice() {
		// TODO Auto-generated method stub
		return this.PRODUCT.getPrice(this.weight);
	}

	@Override
	public void amendOrder(String quantityStr) {
		// TODO Auto-generated method stub
		this.weight = Double.parseDouble(quantityStr);
	}
}
