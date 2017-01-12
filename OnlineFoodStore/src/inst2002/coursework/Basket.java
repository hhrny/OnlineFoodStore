package inst2002.coursework;

import java.util.List;
import java.util.ArrayList;

public class Basket {
    private List<BasketItem> items;

    public Basket() {
        // You SHOULD NOT edit this method
        // constructs an empty basket
        items = new ArrayList<BasketItem>();
    }

    public int calculateTotal() {
        // You SHOULD NOT edit this method
        // calculates the overall total (order price + postage price)
        return calculateSubtotal() + calculatePostage();
    }

    private int calculatePostage() {
		// TODO Auto-generated method stub
    	int sum = 0;
    	for(BasketItem basketItem : items){
    		sum += basketItem.postagePrice();
    	}
		return sum;
	}

	private int calculateSubtotal() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(BasketItem basketItem : items){
			sum += basketItem.orderPrice();
		}
		return sum;
	}

	@Override
    public String toString() {
        // You SHOULD NOT edit this method
        // A nice string representation of the basket.
        String out = "\t### Your Order ###\n\n";
        if (items.isEmpty())
            out += "There is nothing in your order\n\n";
        else {
            for (BasketItem item : items) {
                out += item.toString() + "\n";
            }
            out += "\n  Subtotal:\t" + PriceFormatter.priceToString(calculateSubtotal());
            out += "\n  Postage:\t" + PriceFormatter.priceToString(calculatePostage());
            out += "\n\n  Total:\t" + PriceFormatter.priceToString(calculateTotal());
            out += "\n";
        }
        return out;
    }
	
	public boolean inBasket(Product product){
		for(BasketItem basketItem : items){
			if(basketItem.matchesProduct(product)){
				return true;
			}
		}
		return false;
	}
	
	public void addNewOrder(Product product, String quantityStr){
		if(product instanceof LooseProduct){
			this.items.add(new WeightOrder((LooseProduct)product, quantityStr));
		}
		else if(product instanceof PreboxedProduct || product instanceof PackagedProduct){
			this.items.add(new UnitaryOrder(product, quantityStr));
		}
		else{
			System.out.println("error: error product type");
		}
	}
	
	public void amendOrder(Product product, String quantityStr){
		for(BasketItem basketItem : items){
			if(basketItem.matchesProduct(product)){
				basketItem.amendOrder(quantityStr);
				return;
			}
		}
	}
}
