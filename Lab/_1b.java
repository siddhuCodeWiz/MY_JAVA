package Lab;
import java.util.*;

public class _1b {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("Enter a 3 digit number:");
        n=sc.nextLine(); 
        String d = n.substring(0, 1)+n.substring(2, 3);
        // System.out.println(d);
        int nu = Integer.parseInt(n);
        int de = Integer.parseInt(d);

        if(nu%de == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }    
}
