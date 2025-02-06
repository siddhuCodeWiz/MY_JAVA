package Mine.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Sid", "Pranav", "Sravan", "Sairam");
        List<String> toUpp = new ArrayList<>();
        toUpp = names.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
        System.out.println(toUpp);
    }
}
