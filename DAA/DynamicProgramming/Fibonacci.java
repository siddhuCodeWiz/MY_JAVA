package DAA.DynamicProgramming;
import java.util.*;

public class Fibonacci {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int count = 0;

    public int fibonacci(int n){
        if(n==0 || n==1){
            hm.putIfAbsent(n, n);
            return n;
        }

        int res = hm.getOrDefault(n-1, fibonacci(n-1))+hm.getOrDefault(n-2, fibonacci(n-2));
        System.out.println(n+" "+res);
        hm.put(n, res);
        return res;

    }

    public static void main(String[] args) {
        Fibonacci f1 = new Fibonacci();

        System.out.println(f1.fibonacci(7));
    }
}
