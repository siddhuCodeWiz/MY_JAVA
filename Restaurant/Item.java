package Restaurant;

public class Item {
    String dishname;
    float price;
    boolean isVeg;
    String cuisine;

    public Item(String dishname, float price, boolean isVeg, String cuisine){
        this.dishname = dishname;
        this.price = price;
        this.isVeg = isVeg;
        this.cuisine = cuisine;
    }
}
