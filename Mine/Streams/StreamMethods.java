package Mine.Streams;
import java.util.*;
import java.util.stream.Collectors;



public class StreamMethods {
    public static void main(String[] args) {
        ArrayList<Vehicle> arr = new ArrayList<>();
        arr.add(new Vehicle("Toyota", "Car", 20000));
        arr.add(new Vehicle("Honda", "Bike", 10000));
        arr.add(new Vehicle("Ford", "SUV", 30000));
        arr.add(new Vehicle("BMW-Davidson", "Bike", 25000));
        arr.add(new Vehicle("Tesla", "Car", 50000));
        arr.add(new Vehicle("BMW", "Sedan", 40000));
        arr.add(new Vehicle("Honda", "Bike", 5000));
        arr.add(new Vehicle("Yamaha", "Bike", 15000));
        arr.add(new Vehicle("Audi", "Car", 60000));
        arr.add(new Vehicle("Mercedes-Benz", "Car", 55000));

        Optional<Integer> mi = arr.stream().filter(obj->obj.vechile_type=="Car").map(pr->pr.price).min((val1, val2)->{
            return val1.compareTo(val2);
        });
        System.out.println(mi.get());
        
        Optional<Integer> ma = arr.stream().filter(obj->obj.vechile_type=="Car").map(pr->pr.price).max((val1, val2)->{
            return val1.compareTo(val2);
        });
        System.out.println(ma.get());


        Optional<String> coms = arr.stream().map(obj->obj.company_name).distinct().reduce((val, combinedVal)->{
            return val+" "+combinedVal;
        });
        System.out.println(coms.get());
        System.out.println();

        List<Vehicle> sortedOrder;
        // Sort bikes by price and give their companies names in asc and desc order
        sortedOrder = arr.stream().filter(obj->obj.vechile_type.equals("Bike")).sorted((val1, val2)->{
            if(val1.price > val2.price) return 1;
            else if(val1.price < val2.price) return -1;
            else return 0;
        }).collect(Collectors.toList());
        System.out.println(sortedOrder);


        Set<String> fruits = new HashSet<>();
        fruits.add("One apple");
        fruits.add("One mango");
        fruits.add("Two apples");
        fruits.add("More grapes");
        fruits.add("Two watermelons");

        boolean result = fruits.stream().anyMatch(ele->ele.startsWith("One"));
        System.out.println(result);

        result = fruits.stream().allMatch(ele->ele.startsWith("One"));
        System.out.println(result);

        result = fruits.parallelStream().noneMatch(ele->ele.startsWith("fgbdd"));
        System.out.println(result);
    }

}


class Vehicle{
    String company_name;
    String vechile_type;
    int price;

    Vehicle(String company_name, String vechile_type, int price){
        this.company_name=company_name;
        this.vechile_type=vechile_type;
        this.price=price;
    }

    @Override
    public String toString(){
        return company_name+" "+vechile_type+" "+price;
    }
}