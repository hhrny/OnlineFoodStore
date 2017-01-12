package inst2002.coursework;

public abstract class Product {

    // You DO NOT NEED to edit this class
    // You may choose to add attributes or methods

    protected final String NAME;
    protected static final int MAXLENGTHNAME = 24;

    public static final int SMALLPARCELPOSTAGE2KG = 395;
    public static final int PARCELPOSTAGE2KG = 605;
    public static final int PARCELPOSTAGE5KG = 1485;
    public static final int PARCELPOSTAGE10KG = 2135;
    public static final int PARCELPOSTAGE20KG = 2965;

    public Product(String name) {
        // You DO NOT NEED to edit this method.
        if (name.length() > MAXLENGTHNAME) {
            throw new RuntimeException("Name cannot be longer than 24 letters");
        }
        this.NAME = name;
    }

    public String getName() {
        // You DO NOT NEED to edit this method.
        return NAME;
    }

    public String getPaddedName() {
        // You DO NOT NEED to edit this method.
        // a modified getter method which gets the name in a fixed length string
        String paddedName = NAME;
        while (paddedName.length() < 24) {
            paddedName += " ";
        }
        return paddedName;
    }

    public abstract String toProductListEntry(int id);
}
