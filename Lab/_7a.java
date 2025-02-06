package Lab;
import java.util.*;

public class _7a {
    public static int[] addition(int[] a){
        int sum = 0;
        for(int i=0; i<a.length; i++){
            a[i]+=sum;
            sum=a[i];
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            System.out.print("Enter size of the array: ");
            sc = new Scanner(System.in);
            int n= sc.nextInt();
            if(n<=0){
                throw new IllegalArgumentException();
            }

            int a[] = new int[n];
            System.out.println("Enter the numbers: ");
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }

            a = _7a.addition(a);

            for(int i=0; i<n; i++){
                System.out.print(a[i]+" ");
            }
        } catch (Exception e) {
            System.out.println("Invaliv arguments "+e);
        }
    }    
}
