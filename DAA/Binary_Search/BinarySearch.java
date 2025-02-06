package DAA.Binary_Search;

public class BinarySearch {
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
    public static void main(String[] args) {
        int[] arr = {0,1,3,6,7,9,11,13};

        int key = 13;
        System.out.println(binarySearch(arr, key, 0, arr.length-1));
    }
}
