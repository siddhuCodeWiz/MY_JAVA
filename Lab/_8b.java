package Lab;
import java.util.*;

class CompareStrings implements Comparator<Map.Entry<String, Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
        // return o1.getKey().compareTo(o2.getKey());
        int diff = o2.getValue() - o1.getValue();

        if(diff!=0){
            return diff;
        }
        else{
            return o1.getKey().compareTo(o2.getKey());
        }
    }
}

public class _8b {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();

        // ArrayList<String> a = new ArrayList<>();
        HashMap<String, Integer> h = new HashMap<>();
        String[] s = l.split("\\s+");
        for(String r: s){
            h.put(r, h.getOrDefault(r, 0)+1);
        }

        List<Map.Entry<String, Integer>> ll = new ArrayList<>(h.entrySet());

        Collections.sort(ll, new CompareStrings());

        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int c=0;

        for(Map.Entry<String, Integer> e : ll){
            System.out.println(e.getKey()+"  "+e.getValue());
            c++;
            if(c==n){
                break;
            }
        }
        sc.close();
    }
}
