package DAA.Strings;

/*Vihaan is given a pair of words: word1 and word2, he is asked to create a method which
returns the numbers of characters in a word formed from long lasting frequent posteriority.
Posteriority is a latest word formed from the native word with few characters removed
without modifying the corresponding order of the left over characters.
A frequent posteriority of two words is a posteriority that is frequent to both words.
Return 0 if no common posteriority.

Input Format:
-------------
Two space separated strings S1, S2.

Output Format:
--------------
Print an integer, the length of longest common subsequence.

Sample Input-1:
---------------
abcde ace

Sample Output-1:
----------------
3

Sample Input-2:
---------------
acd bef

Sample Output-2:
----------------
0
 */
import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String s1 = sc.next();
        String s2 = sc.next();
        
        LCS_Memoization m1 = new LCS_Memoization(s1, s2);
        System.out.println(m1.lcs());

        LCS_Tablulation m2 = new LCS_Tablulation(s1, s2);
        System.out.println(m2.lcs());

        sc.close();

    }
}


class LCS_Tablulation{
    String s1;
    String s2;

    LCS_Tablulation(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public int lcs() {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }
}


class LCS_Memoization {
    String s1;
    String s2;
    int[][] dp;

    LCS_Memoization(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
    }

    public int lcs() {
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        return helper(i1, i2);
    }

    public int helper(int i1, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = 1 + helper(i1 - 1, i2 - 1);
        } else {
            dp[i1][i2] = Math.max(helper(i1 - 1, i2), helper(i1, i2 - 1));
        }

        return dp[i1][i2];
    }
}