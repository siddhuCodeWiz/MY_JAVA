package DAA.Greedy_Algo;
// You are given an array height that represents the height of a series of vertical pillars standing on a flat surface. 
// The pillars are located at indices (i, 0) and extend vertically to the height height[i]. 
// The task is to find two pillars that can form a container with the x-axis (ground) that can store the maximum amount of water between them.

// Your goal is to maximize the water held between any two pillars, taking into consideration the height of the shorter pillar and the distance between them.

// Input Format:
// -------------
// Line-1: An integer n, representing the number of pillars.
// Line-2: n space-separated integers representing the heights of the pillars.

// Output Format:
// --------------
// Line-1: Print an integer representing the maximum amount of water that the container formed by two pillars can store.

// Constraints:
// ------------
// 2 <= n <= 10^5
// 0 <= height[i] <= 10^4

// Sample Input-1:
// ---------------
// 9
// 1 8 6 2 5 4 8 3 7

// Sample Output-1:
// ----------------
// 49

// Explanation:
// The best choice is the pillar at index 1 (height 8) and the pillar at index 8 (height 7). The distance between them is 7, and the minimum height is 7, thus the water stored is 7 * 7 = 49.


// Sample Input-2:
// ---------------
// 2
// 1 1

// Sample Output-2:
// ----------------
// 1

// Explanation:
// The only two pillars are at index 0 and index 1, both with height 1. The distance between them is 1, so the water stored is 1 * 1 = 1.
import java.util.*;

public class Max_water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=0; i<n; i++){
            ar.add(sc.nextInt());
        }

        System.out.println(findMaxWater(n, ar));
        System.out.println(findMaxWater_greedy(n, ar));
    }

    public static int findMaxWater(int n, ArrayList<Integer> ar){
        int maxw = 0;

        for(int i=0; i<ar.size(); i++){
            for(int j=i+1; j<ar.size(); j++){
                int currc = (j-i)*Math.min(ar.get(i), ar.get(j));
                if(maxw < (currc)){
                    maxw = currc;
                }
            }
        }
        return maxw;
    }


    public static int findMaxWater_greedy(int n, ArrayList<Integer> ar){
        int i=0;
        int j = ar.size()-1;
        int maxw =0;
        while(i<j){
            int currc = (j-i)*Math.min(ar.get(i), ar.get(j));
            if(maxw < (currc)){
                maxw = currc;
            }

            if(maxw < (j-(i+1))*Math.min(ar.get(i+1), ar.get(j))){
                i=i+1;
            } else{
                j=j-1;
            }
        }
        return maxw;
    }
}
