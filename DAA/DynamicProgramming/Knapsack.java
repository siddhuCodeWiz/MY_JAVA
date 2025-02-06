package DAA.DynamicProgramming;

/*Mr. Dharma is shopping at D-Mart with a basket that has a capacity C. 
He has a wishlist of N products, where each product has a cost and a quantity. 

His goal is to purchase products in such a way that:
	-The total quantity of the selected products does not exceed the basket capacity C.
	-The total cost of the selected products is maximized among all possible combinations.

Your task is to help Mr. Dharma determine the maximum cost he can achieve under the given constraints.

Input Format:
--------------
Line-1: Two space-separated integers N and C, representing the number of products and the basket capacity, respectively.
Next N lines: Two space-separated integers Ci and Qi, representing the cost and quantity of the ith product.

Output Format:
--------------
Line-1: Print an integer, the maximum cost Mr. Dharma can achieve.

Constraints:
------------
*1≤N≤100 (Number of products)
*1≤C≤1000 (Basket capacity)
*1≤Ci,Qi≤100 (Cost and quantity of each product)

Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
The selected products are:
	Product 1 (Cost = 10, Quantity = 2)
	Product 2 (Cost = 10, Quantity = 4)
	Product 4 (Cost = 18, Quantity = 9)

Total cost = 10 + 10 + 18 = 38
Total quantity = 2 + 4 + 9 = 15

Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
The selected products are:
	Product 1 (Cost = 18, Quantity = 6)
	Product 2 (Cost = 20, Quantity = 3)
	Product 4 (Cost = 18, Quantity = 9)

Total cost = 18 + 20 + 18 = 56
Total quantity = 6 + 3 + 9 = 18 */


import java.util.*;

public class Knapsack {
    int n;
    int cap;
    int[] val;
    int[] wt;
    int maxxx = 0;

    void maxValue(int currInd, int remCap, int currVal){
        if(currInd==n || remCap<=0){
            maxxx = Math.max(maxxx, currVal);
            // System.out.println(maxxx+"        "+currVal);
            return;
        }

        // System.out.println("Rem Cap: "+remCap+" Curr Val: "+currVal);
        if(remCap-wt[currInd] >=0){
            maxValue(currInd+1, remCap-wt[currInd], currVal+val[currInd]);
        }
        maxValue(currInd+1, remCap, currVal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Knapsack kk = new Knapsack();
        kk.n = sc.nextInt();
        kk.cap = sc.nextInt();

        kk.val = new int[kk.n];
        kk.wt = new int[kk.n];

        for(int i=0; i<kk.n; i++){
            kk.val[i] = sc.nextInt();
            kk.wt[i] = sc.nextInt();
        }

        kk.maxValue(0, kk.cap, 0);
        System.out.println(kk.maxxx);

        sc.close();
    }
}
