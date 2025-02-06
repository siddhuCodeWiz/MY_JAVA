package PreFS;


// Question 1
// You are working on a team that is building a custom URL shortening service. The service 
// needs to create unique, user-friendly abbreviations for long URLs, while ensuring that 
// no two different URLs map to the same abbreviation.

// To validate whether a custom abbreviation correctly maps to the original URL, your team 
// has built an abbreviation validation system. However, the system must also check for 
// compliance with the following rules:
// 	- The abbreviation can replace any number of non-adjacent, non-empty substrings 
// 	  in the URL with their lengths (as integers).
// 	- The lengths of these substrings must not have leading zeros.
// 	- Adjacent substrings cannot be replaced, and no empty substrings should be replaced.
// 	- The abbreviation must be able to fully and accurately recreate the original URL.

// Your task is to implement a code that to determine if the abbreviation is valid for the given 
// URL or not. If it is valid, print true, otherwise "false"


// Constraints:
// ------------
// 1 <= URL.length <= 50, The URL consists of lowercase English letters.
// 1 <= abbr.length <= 20, abbr consists of lowercase English letters and digits.
// All integers in abbr will fit in a 32-bit integer.


// Input Format:
// -------------
// Line-1: Two space separated strings, URL and abbr.

// Output Format:
// -------------
// A Boolean Value.


// Sample Input-1:
// ---------------
// hypertexttransferprotocol h23l

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// The abbreviation "h23l" corresponds to "h ypertexttransferprotoco l" where 
// the substring "ypertexttransferprotoco" is replaced by its length of 23.


// Sample Input-2:
// ---------------
// applicationprogramminginterface app843minginterface

// Sample Output-2: 
// ----------------
// false

// Explanation:
// ------------
// The abbreviation "app843minginterface" corresponds to "app lication prog ram 
// minginterface" where the substrings "lication", "prog", "ram" are adjacent 
// substrings, and not allowed to be replaced


// Sample Input-3:
// ---------------
// webdevelopment webd0evelopment

// Sample Output-3: 
// ----------------
// false

// Explanation:
// ------------
// The abbreviation "webd0evelopment" is invalid because "0" is not allowed 
// (no leading zeros, and an empty substring cannot be replaced).

import java.util.*;

public class Day_6 {

    public static boolean validateURL(String s1, String s2){
        int i = 0;
        int j = 0;

        while(i < s1.length() && j < s2.length()){
            if(Character.isDigit(s2.charAt(j))){
                if(s2.charAt(j) == '0') {
                    return false;
                }
                int num = 0;
                while(j < s2.length() && Character.isDigit(s2.charAt(j))){
                    num = num * 10 + (s2.charAt(j) - '0');
                    j++;
                }
                i += num;
                if(i > s1.length()) {
                    return false;
                }
            } else {
                if(s1.charAt(i) != s2.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == s1.length() && j == s2.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        // String s1 = sc.next();
        // String s2 = sc.next();
        
        // // String s1 = "hypertexttransferprotocol";
        // // String s2 = "h23l";
        
        // System.out.println(validateURL(s1, s2));




        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        Second.second(x,y,z);

        sc.close();
    }
}







// Question 2
// You are participating in a token distribution game with three decks of tokens, 
// each containing x, y, and z tokens, respectively. Your goal is to maximize your 
// number of passes by distributing tokens according to the following rules:

// In each move, you must pick two different non-empty decks, take 1 token from each, 
// and distribute them to a shared pot. For each move, you earn 1 pass.
// The game ends when there are fewer than two non-empty decks 
// (i.e., no more moves can be made).

// Your objective is to find the maximum number of passes you can achieve by optimally
// distributing tokens. Given three integers x, y, and z representing the sizes of 
// the three decks, return the maximum possible passes you can earn.

// Input Format:
// -------------
// Three space separated integers, X,Y, Z.

// Output Format:
// --------------
// Print an integer, maximum possible passes you can earn.


// Sample Input-1:
// ---------------
// 3 5 7

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// The game begins with (3, 5, 7). One optimal set of moves is:
// Take from the 1st and 3rd decks, state becomes (2, 5, 6)
// Take from the 1st and 3rd decks, state becomes (1, 5, 5)
// Take from the 1st and 3rd decks, state becomes (0, 5, 4)
// Take from the 2nd and 3rd decks, state becomes (0, 4, 3)
// Take from the 2nd and 3rd decks, state becomes (0, 3, 2)
// Take from the 2nd and 3rd decks, state becomes (0, 2, 1)
// Take from the 2nd and 3rd decks, state becomes (0, 1, 0)

// At this point, there are fewer than two non-empty decks, and 
// the game ends with a total of 7 passes.


// Sample Input-2:
// ---------------
// 4 4 5

// Sample Output-2:
// ----------------
// 6

// Explanation:
// ------------
// One optimal set of moves:
// Take from the 1st and 2nd decks, state becomes (3, 3, 5)
// Take from the 1st and 3rd decks, state becomes (2, 3, 4)
// Take from the 1st and 3rd decks, state becomes (1, 3, 3)
// Take from the 1st and 3rd decks, state becomes (0, 3, 2)
// Take from the 2nd and 3rd decks, state becomes (0, 2, 1)
// Take from the 2nd and 3rd decks, state becomes (0, 1, 0)

// The game ends with a total of 6 passes.

class Second{
    
    public static void second(int x, int y, int z){
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(x);
        ar.add(y);
        ar.add(z);
        Collections.sort(ar, Collections.reverseOrder());

        System.out.println((ar.get(0)-ar.get(1))+ar.get(1));
    }
}