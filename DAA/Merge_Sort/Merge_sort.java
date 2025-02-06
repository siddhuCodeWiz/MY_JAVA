package DAA.Merge_Sort;

// You are given an unsorted array of integers. 
// Your task is to implement the MergeSort algorithm to sort the array in ascending order.

// MergeSort is a divide-and-conquer algorithm that:
// 	-Divides the array into two halves.
// 	-Recursively sorts the two halves.
// 	-Merges the two sorted halves to produce the final sorted array.
// 	-Your task is to write a function that sorts the given array using MergeSort.

// Input Format:
// --------------
// Line-1: An integer n (the size of the array).
// Line-2: n space-separated integers representing the elements of the array.

// Output Format:
// ---------------
// Line-1: Output the sorted array in a single line, with each element separated by a space.

// Constraints:
// ------------
// 1 ≤ n ≤ 10^5
// -10^9 ≤ arr[i] ≤ 10^9

// Sample Input-1:
// ---------------
// 6
// 12 11 13 5 6 7

// Sample Output-1:
// ----------------
// 5 6 7 11 12 13

// Sample Input-2:
// ---------------
// 5
// 10 1 2 8 5

// Sample Output-2:
// ----------------
// 1 2 5 8 10
import java.util.*;
public class Merge_sort {
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
        }
        // int n = 7;
        // int[] arr = { 12, 13, 4, 0, 5, 3,12 };
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
