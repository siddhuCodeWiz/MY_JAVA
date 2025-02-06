package DAA.DynamicProgramming;

/*Pavan is playing a game where there are N levels and each level has some points in it. 
level[i] is the points to spend on ith level(0-indexed) to move forward. 
Inorder to win the game he has to reach the top level.

The rule book explains "In one step you have to spend the points given on the 
present level and you can either cross one level or two levels forward".

Return the minimum number of points to spend to win the game.

Note:You are allowed to start at either level-0 or level-1.

Constraints:
-------------
    2 <= N <=1000
    0 <= level[i] <= 999

Input Format:
-------------
Line-1: An integer N, representing the number of levels.
Line-2: N space-separated integers, representing the points required for each level.
  
Output Format:
--------------
Line-1: Print an integer, representing the minimum number of points needed to win the game.


Sample Input-1:
---------------
3
20 30 40
  
Sample Output-1:
----------------
30

Explanation:
------------
Pavan can start at index-1 by spending points 30 and he can win.
   
Sample Input-2:
---------------
7
2 3 50 2 2 50 2 
  
Sample Output-2:
----------------
9

Explanation:
------------
Start at index-1:
  -Spend 3 points and reach to index-3
  -Spend 2 points and reach to index-4
  -Spend 2 points and reach to index-6
  -Spend 2 points and he wins. */

import java.util.*;
public class MinCostClimbingStairs {
    int N;
    ArrayList<Integer> arr;
    int minnn = Integer.MAX_VALUE;
    public void minCost(int currInd, int currVal){
        if(currInd>=N){
            minnn = Math.min(currVal, minnn);
            return;
        }
        // System.out.println(currVal);
        minCost(currInd+1, currVal+arr.get(currInd));
        minCost(currInd+2, currVal+arr.get(currInd));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinCostClimbingStairs ms = new MinCostClimbingStairs();
        ms.N = sc.nextInt();
        ms.arr = new ArrayList<>();

        for(int i=0; i<ms.N; i++){
            ms.arr.add(sc.nextInt());
        }
        ms.minCost(0, 0);
        ms.minCost(1, 0);
        System.out.println(ms.minnn);
        sc.close();
    }
}
