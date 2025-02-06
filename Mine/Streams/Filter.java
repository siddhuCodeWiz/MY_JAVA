package Mine.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        // ArrayList<Integer> num = new ArrayList<>();
        // num.add(10);
        // num.add(20);
        // num.add(15);
        // num.add(11);
        // num.add(30);
        Integer[] arr = {10,20,15,11,30};
        List<Integer> num = Arrays.asList(arr);

        // List<Integer> evenNums = num.stream().filter(n->n%2==0).collect(Collectors.toList());
        // System.out.println(evenNums);

        num.stream().filter(n->n%2==0).forEach(System.out::println);

        List<String> names = Arrays.asList("Sid", "Pranav", "Sravan", "Sairam");
        List<String> Snames = names.stream().filter(n->n.startsWith("S")).collect(Collectors.toList());
        System.out.println(Snames);
    }    
}
