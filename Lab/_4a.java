package Lab;
import java.util.*;
public class _4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word 1: ");
        String w1 = sc.nextLine();
        System.out.print("Enter word 2: ");
        String w2 = sc.nextLine();

        int c=0; int m=0;

        for(int i=0; i<w1.length(); i++){
            for(int j=m; j<w2.length(); j++){
                if(w1.charAt(i) == w2.charAt(j)){
                    c++;
                    m=j+1;
                    break;
                }
            }
        }
        System.out.println(c);
        sc.close();
    }
}
