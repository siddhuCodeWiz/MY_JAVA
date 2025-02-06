package DAA.Binary_Search;
import java.util.*;
public class LeastCommon {


    public static int binarySearch(int[] arr, int key, int low, int high){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        System.out.println("Low:"+low+" High:"+high+" Ele:"+arr[mid]);
        if(arr[mid] == key){
            return mid;
        }
        else if(arr[mid]>key){
            high = mid-1;
            return binarySearch(arr, key, low, high);
        }
        else{
            low = mid+1;
            return binarySearch(arr, key, low, high);
        }
    }


    public static void findLeastCommon(int n, int m, int[][] arr){
        o: for(int i=0; i<n; i++){
            i: for(int j=i+1; j<n; j++){
                ii: for(int )
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 3, m=4;
        int[][] arr = {{1,2,3,4},{2,3,4,5},{3,4,5,6}};

    }
}
