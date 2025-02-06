package DAA.Strings;

/*The Valid shortcuts of a string "abcd", are as follows:
abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
 */
import java.util.*;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        // sc.nextLine();
        String masked = sc.next();

        int i = 0;
        int j = 0;
        boolean b = true;

        OUTER: while (i < word.length() && j < masked.length()) {
            if (Character.isDigit(masked.charAt(j))) {
                String num = "";
                while (j < masked.length() && Character.isDigit(masked.charAt(j))) {
                    num = num + masked.substring(j, j + 1);
                    j++;
                }

                int n = Integer.parseInt(num);
                // System.out.println(n);
                i = i + n;
                if (i > word.length()) {
                    b = false;
                    break OUTER;
                }
                // j++;
            } else {
                if (i < word.length() && j < masked.length() && word.charAt(i) == masked.charAt(j)) {
                    i++;
                    j++;
                } else {
                    b = false;
                    break OUTER;
                }
            }
            // System.out.println(b);
        }

        System.out.println(b);
    }
}
