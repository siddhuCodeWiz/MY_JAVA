package PreFS;

// 1. Mapping two strings for validity
// In a secret code system, two distinct ancient civilizations, `Alpha` and `Beta`,
// used their own unique symbols to encode messages. However, these symbols
// represent the same meanings in their respective languages.

// Given two encoded messages, one from Alpha and one from Beta, determine
// if these messages are translatable — meaning that the symbols used in Alpha's
// message can be uniquely translated to the symbols in Beta's message.

// The translation must follow these rules:
// - Each symbol in Alpha's message must map to exactly one symbol in Beta's
// message, and vice versa.
// - No two symbols from Alpha's message can map to the same symbol in Beta's
// message.
// - The order of symbols must be preserved in the translation.
// - A symbol may map to itself if needed.

// Your task is to determine whether these ancient messages from two different
// civilizations can be translated perfectly while maintaining their symbolic
// structure. If yes print "true", otherwise, "false".

// ## Input Format:

// Space separated strings, Alpha and Beta messages.

// ## Output Format:

// Boolean value.

// ## Sample Input-1:

// star moon

// ## Sample Output-1:

// false

// ## Explanation:

// In this case, 's' would need to map to 'm', and 't' would need to map to 'o',
// but then 'a' and 'r' would both need to map to 'n', which violates the rule
// that no two symbols may map to the same symbol.

// ## Sample Input-2:

// sun day

// ## Sample Output-2:

// true

// ## Explanation:

// Here, each symbol in the Alpha message has a unique mapping to the Beta message,
// preserving the order and meaning: 's' -> 'd', 'u' -> 'a', and 'n' -> 'y'.
import java.util.*;

public class Date_23_09 {
    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        LinkedHashMap<Character, Character> hm = new LinkedHashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!(hm.containsKey(s1.charAt(i)))) {
                hm.put(s1.charAt(i), s2.charAt(i));
            } else {
                if (!(hm.get(s1.charAt(i)) == s2.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // String s1, s2;
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // String[] arr = s.split(" ");
        // s1 = arr[0];
        // s2 = arr[1];
        // System.out.println(check(s1, s2));
        // sc.close();






        System.out.println("2nd question: ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        arr = Second.produce(n, arr);
        for(int k=0; k<n; k++){
            System.out.print(arr[k]+" ");
        }
        sc.close();
    }
}









// You are developing an inventory management system for a retail company.
// The company wants to introduce a new feature where it can predict when
// the inventory for a product might need restocking. The inventory levels
// for various products are recorded daily, and the company wants to monitor
// the next higher stock level for each product to anticipate demand.

// Given an array stock levels where each element represents the daily inventory
// level of a particular product over a certain period, write a function to find
// the "next higher stock level" for every day. The "next higher stock level" for
// a given day is defined as the first higher stock level recorded in
// the subsequent days. If no higher stock level is found in the following days,
// return -1.

// ## Sample Input:

// Line-1: An integer N, Number of days.
// Line-2: N space separated integers,

// ## Sample Output:

// An integer array according to problem.

// ## Sample Input-1:

// 3
// 10 15 10

// ## Sample Output-1:

// [15, -1, -1]

// ## Explanation-1:

// - For day 1 (stock level = 10), the next higher stock level is 15.
// - For day 2 (stock level = 15), there is no higher stock level in the subsequent days.
// - For day 3 (stock level = 10), there is no higher stock level in the subsequent days.

// ## Sample Input-2:

// 6
// 20 25 30 15 20 35

// ## Sample Output-2:

// [25, 30, 35, 20, 35, -1]

// ## Explanation-2:

// - For day 1 (stock level = 20), the next higher stock level is 25.
// - For day 2 (stock level = 25), the next higher stock level is 30.
// - For day 3 (stock level = 30), the next higher stock level is 35.
// - For day 4 (stock level = 15), the next higher stock level is 20.
// - For day 5 (stock level = 20), the next higher stock level is 35.
// - For day 6 (stock level = 35), there is no higher stock level in
// the subsequent days.




class Second{
    public static int[] produce(int n, int[] arr){
        if(n==0 || n==1){
            return arr;
        }
        int curr;
        boolean en;
        for(int i=0; i<n; i++){
            curr=arr[i];
            en=false;
            for(int j=i+1; j<n; j++){
                if(arr[j]>curr){
                    arr[i] = arr[j];
                    en=true;
                    break;
                }
            }
            if(!en){
                arr[i] = -1;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        
    }
}