package DAA.Merge_Sort;



// Given an array nums of size n, return the majority element. 
// The majority element is the element that appears more than ⌊n / 2⌋ times.

// You may assume that the majority element always exists in the array.

// Input Format:
// --------------
// Line-1: An integer n (the size of the array).
// Line-2: n space-separated integers representing the elements of the array.

// Output Format:
// --------------
// Line-1: Output a single integer, the majority element.

// Constraints:
// -------------
// 1 ≤ n ≤ 5 * 10^4
// -10^9 ≤ nums[i] ≤ 10^9


// Sample Input-1:
// ---------------
// 3
// 3 2 3

// Sample Output-1:
// ----------------
// 3

// Explanation:
// The number 3 appears more than n/2 times, so it is the majority element.

// Sample Input-2:
// ---------------
// 7
// 2 2 1 1 1 2 2

// Sample Output-2:
// ----------------
// 2

// Explanation:
// The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.
import java.util.*;
public class Majority_element {

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = 0;
        int[] temp = new int[r - l + 1];
            // for (int x = 0; x < arr.length; x++) {
            //     System.out.print(arr[x] + " ");
            // }
            // System.out.println();
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n-1);

        System.out.println(arr[n/2]);
    }
}
