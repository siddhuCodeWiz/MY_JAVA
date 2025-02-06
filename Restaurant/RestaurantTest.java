package Restaurant;

import java.util.ArrayList;

public class RestaurantTest {

    public static void main(String[] args) {
        Item manchuria = new Item("Manchuria", 120, true, "Chinese");

        Item frenchfries = new Item("FrenchFries", 80.0f, true, "French");

        ArrayList<Item> its = new ArrayList<Item>();
        its.add(manchuria);
        its.add(frenchfries);

        Restaurant r = new Restaurant("Swagat", 4, its);
        float ans = r.bill(its);
        System.out.println(ans);
    }
    
}
