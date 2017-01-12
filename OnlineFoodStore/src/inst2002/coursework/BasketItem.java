package inst2002.coursework;

public interface BasketItem {

    public int orderPrice();

    public int postagePrice();

    public boolean matchesProduct(Product product);

    public void amendOrder(String quantityStr);

    public String toString();
}
