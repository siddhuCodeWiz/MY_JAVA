package Lab;
import java.util.*;

public class _1a {
    public static void main(String[] args){
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n;
        n= sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<i; j++){
                if(i == (j)*(j+1)){
                    System.out.println(i);
                }
            }
        }
        sc.close();;
    }    
}
