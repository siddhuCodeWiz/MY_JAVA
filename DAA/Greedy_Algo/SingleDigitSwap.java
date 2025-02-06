package DAA.Greedy_Algo;
// You are given an integer num. Your task is to maximize its value by swapping at most two digits once. 
// Write a program to return the maximum possible value after performing the swap.

// If no swap can increase the value, return the original number.

// Input Format:
// --------------
// Line-1: An integer num, where 0 <= num <= 10^8.

// Output Format:
// --------------
// Line-1: Return an integer representing the maximum value obtained after swapping two digits at most once.

// Sample Input-1:
// ---------------
// 2736

// Sample Output-1:
// ----------------
// 7236

// Explanation:
// ------------
// Swap the digit 2 with 7, resulting in the number 7236, which is the maximum possible value.

// Sample Input-2:
// ---------------
// 9973

// Sample Output-2:
// ----------------
// 9973

// Explanation:
// ------------
// No swap can make the number larger, so return the original number.
import java.util.*;

// public class SingleDigitSwap {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         System.out.println(findMax(n));
//     }

//     public static int findMax(int n){
//         StringBuilder sb = new StringBuilder(Integer.toString(n));
//         int m = Integer.parseInt(sb.toString());
//         int i=0;
//         int j = i+1;

//         while(i<sb.length() && j<sb.length()){
//             String ns1 = sb.replace(i, i+1, sb.substring(j, j+1)).toString();
//             String ns2 = sb.replace(j, j+1, sb.substring(i, i+1)).toString();
//             if(m<Integer.parseInt(ns1)){
//                 m = Integer.parseInt(ns1);
//                 i=i+1;
//             }else if(m<Integer.parseInt(ns2)){
//                 m = Integer.parseInt(ns2);
//                 j=j-1;
//             } else{
//                 break;
//             }
//         }
//         return m;
//     }
// }




import java.util.*;

public class SingleDigitSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(findMax(num));
        sc.close();
    }

    public static int findMax(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}
