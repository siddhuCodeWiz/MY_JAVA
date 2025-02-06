package DAA.Binary_Search;

// Given an array of strings strs, find the longest common prefix among all strings.

// If there is no common prefix, return an empty string "".

// NOTE: Solve Using Binary Search

// Input Format:
// -------------
// Line-1: An integer n, the number of strings in the array.
// Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

// Output Format:
// --------------
// Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

// Constraints:
// ------------
// 1 ≤ n ≤ 200
// 0 ≤ strs[i].length ≤ 200
// strs[i] consists of only lowercase English letters.


// Sample Input-1:
// ---------------
// 3
// flower flow flight

// Sample Output-1:
// ----------------
// fl

// Explanation:
// The longest common prefix of the strings flower, flow, and flight is "fl".

// Sample Input-2:
// ---------------
// 3
// dog racecar car

// Sample Output-2:
// ----------------
// ""

// Explanation:
// There is no common prefix among the input strings.
import java.util.*;
public class LongestCommonPrefix {

    public static String findSmallest(String[] arr){
        // int len = arr[0].length();
        String s = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].length() < s.length()){
                s=arr[i];
            }
        }
        return s;
    }

    public static String findPre(int n, String[] arr){
        String smallest = findSmallest(arr);
        // LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<smallest.length(); i++){
            for(int j=0; j<arr.length; j++){
                if(!(smallest.charAt(i) == arr[j].charAt(i))){
                    return sb.toString();
                }
            }
            sb.append(smallest.charAt(i));
        }
        return sb.toString();
    }

    public static String findPre_HashMap(int n, String[] arr){
        String smallest = findSmallest(arr);
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder("");
        boolean en = false;
        for(int i=0; i<smallest.length(); i++){
            hm.putIfAbsent(smallest.charAt(i), 0);
            for(int j=0; j<arr.length; j++){
                if(smallest.charAt(i) == arr[j].charAt(i)){
                    hm.put(smallest.charAt(i), hm.get(smallest.charAt(i))+1);
                } else{
                    en = true;
                }
            }
            if(en==true){
                break;
            }
        }
        for(Map.Entry<Character, Integer> val: hm.entrySet()){
            System.out.println(val.getKey()+":"+val.getValue());
        }
        for(Map.Entry<Character, Integer> val: hm.entrySet()){
            if(val.getValue()>=n){
                int a = val.getValue();
                if(a>n){
                    for(int k=0; k<a/n; k++){
                        sb.append(val.getKey());
                    }
                } else{
                    sb.append(val.getKey());
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }

        System.out.println(findPre_HashMap(n, arr));
        sc.close();
    }
}
