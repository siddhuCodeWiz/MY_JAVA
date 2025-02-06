package Lab;
import java.util.*;


public class _4b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word 1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter word 2: ");
        String s2 = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        int i=0, j=0;
        while (i<s1.length() && j<s2.length()) {
            sb.append(s1.charAt(i));
            i++;
            sb.append(s2.charAt(j));
            j++;
        }
        while(i<s1.length()){
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<s2.length()){
            sb.append(s2.charAt(j));
            j++;
        }
        System.out.println(sb.toString());
    }   
}
