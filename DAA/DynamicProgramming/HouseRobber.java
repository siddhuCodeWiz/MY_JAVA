package DAA.DynamicProgramming;

/*A group of houses is arranged in a street, and each house has a certain amount of money stashed inside. 
A robber wants to steal the maximum amount of money possible. 
However, there is a catch: 
"the robber cannot rob two adjacent houses as it will alert the police."

You are tasked to calculate the maximum amount of money the robber can steal without alerting the police.

Input Format:
-------------
Line-1: An integer n, representing the number of houses in the street.
Line-2: n space-separated integers, representing the money stashed in each house.
  
Output Format:
--------------
Line-1: An integer, Print the maximum amount of money the robber can steal without alerting the police.


Sample Input-1:
---------------
5
100 50 400 200 100
  
Sample Output-1:
----------------
600

Explanation:
------------
The robber will steal 100, 400 and 100 from the houses.
Refer Hint for more.
   
Sample Input-2:
---------------
5
5 3 4 11 2 
  
Sample Output-2:
----------------
16

Explanation:
------------
Thief will steal 5 and 11 from the houses. */

import java.util.*;
public class HouseRobber {
    int N;
    int[] arr;
    int maxxx;

    void calMaxxx(int currInd, int currVal){
        // System.out.println("Curr Val: "+currVal);
        if(currInd>=N){
            maxxx = Math.max(maxxx, currVal);
            return;
        }
        calMaxxx(currInd+2, currVal+arr[currInd]);
        calMaxxx(currInd+1, currVal);
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        Scanner sc = new Scanner(System.in);
        hr.N = sc.nextInt();
        hr.arr = new int[hr.N];
        for(int i=0; i<hr.N; i++){
            hr.arr[i]=sc.nextInt();
        }
        hr.calMaxxx(0, 0);
        System.out.println(hr.maxxx);
        sc.close();
    }
}
