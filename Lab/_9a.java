package Lab;
import java.util.*;

public class _9a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = sc.nextLine();

        Map<Character, Integer> m  = new LinkedHashMap<>();
        for(int i=0; i<word.length(); i++){
            m.put(word.charAt(i), m.getOrDefault(word.charAt(i), 0)+1);
        }

        for(Map.Entry<Character, Integer> e : m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        sc.close();
    }
}
