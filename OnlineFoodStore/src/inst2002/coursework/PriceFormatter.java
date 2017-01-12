package inst2002.coursework;

public class PriceFormatter {
    // You SHOULD NOT edit this class
    public static String priceToString(int price) {
        int pounds = price/100;
        int pence = price%100;
        return "£" + pounds + "." + (pence < 10? "0"+ pence: ""+ pence);
    }
}
