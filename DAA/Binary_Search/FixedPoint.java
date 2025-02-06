package DAA.Binary_Search;

// import java.util.Scanner;

public class FixedPoint {
    public static int binarySearch(int[] arr, int low, int high, int ans){
        if(low>high){
            return ans;
        }
        int mid = (low+high)/2;
        System.out.println("Low:"+low+" High:"+high+" Ele:"+arr[mid]);
        if(arr[mid] == mid && ans>mid){
            // return mid;
            ans = mid;
            System.out.println("Ans:"+ans);
        }
        if(arr[mid]>=mid){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
        return binarySearch(arr, low, high, ans);
        // return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-10, 1, 2, 10, 4};

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i]=sc.nextInt();
        // }
        System.out.println(binarySearch(arr, 0, arr.length-1, Integer.MAX_VALUE));
    }
}
