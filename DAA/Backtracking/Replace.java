package DAA.Backtracking;
import java.util.*;

public class Replace {
    public static ArrayList<StringBuilder> hs;
    public static void BT(StringBuilder s){
        for(int i=0; i<s.length(); i++){
            // if(!(s.charAt(i)>='0' || s.charAt(i)<='9')){
                if(i>=1 && (s.charAt(i-1)>='0' || s.charAt(i-1)<='9')){
                    int a = Integer.parseInt(s.substring(i-1, i));
                    a++;
                    s.replace(i-1, i+1, Integer.toString(a));
                    hs.add(s);
                    System.out.println(hs);
                    BT(s);
                }
                else if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                    s.replace(i, i+1, Integer.toString(1));
                    hs.add(s);
                    System.out.println(hs);
                    BT(s);
                }
            // }
        }

    }   

    // public static void makeCom(StringBuilder s){

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder s = new StringBuilder(sc.nextLine());
        hs = new ArrayList<>();
        BT(s);
        sc.close();
    }
}
