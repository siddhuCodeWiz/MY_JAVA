package JavaCollections;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiFunction;


public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(40);
        h.add(20);

        // h.forEach(Integer i -> System.out.println(););
        // for (Integer i : h) {
        //     System.out.println(i+" ");

        // }

        // Iterator<Integer> k = h.iterator();
        // while (k.hasNext()) {
            
        // }


        HashMap<Integer, String> m = new HashMap<>();
        m.put(1, "Sid");
        m.put(2, "Pranav");

        Set <Integer> k=m.keySet();
        Collection<String> v = m.values();
        
        // BiFunction<Integer, String, String> a = (b,c) -> 
        for (Integer integer: k) {
            System.out.println(integer+" "+m.get(integer));
            System.out.println(m.get(integer).startsWith("S"));
            System.out.println(m.hashCode());
            m.compute(integer, )
        }
    }
}
