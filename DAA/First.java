package DAA;
import java.util.*;
public class First {

    // public static void binarySearch(int[] arr, int num){
    //     if()
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nums = s.split(",");
        // ArrayList<Integer> ar = new ArrayList<>();
        // ar.
        // for(String i:nums){
        //     System.out.println(i);
        // }
        Integer[] num = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            num[i]=Integer.parseInt(nums[i]);
        }

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int first = -1;
        int last = -1;
        boolean fb=false;
        for(int i=0; i<num.length; i++){
            if(n==num[i]){
                if(fb==false){
                    first=i;
                    fb=true;
                }
                else{
                    last = i;
                }
            }
        }

        System.out.println("First: "+first+"\nLast: "+last);
    }
}

