package Restaurant;

import java.util.ArrayList;

public class Restaurant {
    String name;
    float stars;
    ArrayList<Item> items;

    public Restaurant(String name, float stars, ArrayList<Item> items){
        super();
        this.name = name;
        this.stars = stars;
        this.items = items;
    }

    public boolean order(ArrayList<Item> li){
        System.out.println("Order received");
        return true;
    }

    public float bill(ArrayList<Item> li){
        float sum = 0;
        for(Item i: li){
            sum+=i.price;
        }
        return sum;
    }
}
