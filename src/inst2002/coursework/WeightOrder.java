package inst2002.coursework;

import java.lang.IllegalArgumentException;

public class WeightOrder {
    // You NEED TO complete this class to implement the BasketItem interface

    private double weight;
    private final LooseProduct PRODUCT;

    public WeightOrder(LooseProduct product, String quantityStr) {
        // You DO NOT NEED to edit this method.
        this.PRODUCT = product;
        amendOrder(quantityStr);
    }

    private void amendOrder(String quantityStr) {
		// TODO Auto-generated method stub
		
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

	private int orderPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
