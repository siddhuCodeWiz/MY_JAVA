package DAA.DynamicProgramming;

/*You are given N nodes of a Binary search tree.
To search a node in the binary serach tree, it will cost some freq.
You are given the N nodes as keys[] in sorted order, and the search costs of N nodes
 as freq[], where freq[i] is the cost to search keys[i] element in the BST.

The cost to search a BST node is the level of that node multiplied by its freq. The level of the root is 1.

Your task is to findout the minimum cost of a BST is defines as the total cost of all the BST nodes.
You can form the BST with any element as the root node.

Input Format:
------------------
Line-1: An integer N, number of nodes.
Line-2: N space separate integers, node vals[].
Line-3: N space separate integers, node cost[].

Output Format:
-------------------
Print an integer, minimum search cost of BST.


Sample Input-1:
--------------------
3
10 20 30
23 32 14

Sample Output-1:
----------------------
106

Explanation:
----------------
The BST is: 
		20
		/\
	  10  30

Sample Input-2:
--------------------
4
8 10 12 20
26 34 8 50

Sample Output-2:
----------------------
210

Explanation:
----------------
The BST is: 
		10
		/\
	  8  20
		/
	 12
 */









//  import java.util.*;

//  public class OBST {
 
// 	 public static int optimalCost(int[] freq, int i, int j){
// 		 if(j<i){
// 			 return 0;
// 		 }
// 		 if(i==j){
// 			 return freq[i];
// 		 }
 
// 		 int freqSum = sum(freq, i, j);
 
// 		 int min = Integer.MAX_VALUE;
 
// 		 for (int r = i; r <= j; ++r) {
// 			 int optCost = optimalCost(freq, i, r - 1) + optimalCost(freq, r + 1, j);
// 			 if (optCost < min) min = optCost;
// 		 }
 
// 		 return min+freqSum;
// 	 }
 
// 	 public static int sum(int[] freq, int i, int j){
// 		 int s = 0;
// 		 for(int k=i; k<=j; k++){
// 			 s+=freq[k];
// 		 }
 
// 		 return s;
// 	 }
 
	 
// 	  public static int optimalSearchTree(int n, int[] keys, int[] freq){
// 		 return optimalCost(freq, 0, n-1);
// 	  }
	 
// 	 public static void main(String[] args) {
// 		 Scanner sc = new Scanner(System.in);
// 		 int n = sc.nextInt();
// 		 int[] keys = new int[n];
// 		 int[] freq = new int[n];
 
// 		 for(int i=0; i<n; i++){
// 			 keys[i]=sc.nextInt();
// 			//  freq[i] = sc.nextInt();
// 		 }

// 		 for(int i=0; i<n; i++){
// 			// keys[i]=sc.nextInt();
// 			freq[i] = sc.nextInt();
// 		}
 
// 		 System.out.println(optimalSearchTree(n, keys, freq));
// 	 }
 
//  }










import java.util.*;

public class OBST {

    // Function to calculate the sum of frequencies between indices i and j
    public static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    // Function to find the minimum cost of an optimal binary search tree
    public static int optimalSearchTree(int n, int[] freq) {
        int[][] dp = new int[n][n];

        // Initialize the diagonal values, as each single element subtree cost equals its frequency
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }

        // Fill the dp table for chains of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Sum of frequencies for the current range
                int freqSum = sum(freq, i, j);

                // Try all keys as roots and calculate the minimum cost
                for (int r = i; r <= j; r++) {
                    int cost = (r > i ? dp[i][r - 1] : 0) +
                               (r < j ? dp[r + 1][j] : 0) +
                               freqSum;

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
        }

		for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        System.out.println(optimalSearchTree(n, freq));
    }
}
