package PreFS;

/*Ms Manasa is working on numbers; she is fascinated by number factors.
She is given a number N, she wants to find out all possible ways of 
obtaining N as multiple of its factors.
For example given N =12
can be written as multiple of 2,3 and 4.
and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

Your task is to help Ms Manasa to find the all possible ways of obtaining N 
from its factors and return all the possible ways as shown in the samples.

Input Format:
-------------
An integer N, value of N.

Output Format:
--------------
Print the list of possiblilties.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 2, 3], [2, 6], [3, 4]]


Sample Input-2:
---------------
16

Sample Output-2:
----------------
[[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]
 */
import java.util.*;
public class Day_35 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Problem 1
		// Problem1 p1 = new Problem1(sc.nextInt());
		// p1.findFactors();
		// System.out.println("Solution: "+p1.solution);




		// Problem 2
		// Problem2 p2 = new Problem2(sc.nextInt());
		// System.out.println(p2.hs);
		// System.out.println(p2.hs.size());


		// Problem 3
		Problem3 p3 = new Problem3();
		p3.size = sc.nextInt();
		p3.mat = new int[p3.size][p3.size];
		for(int i=0; i<p3.size; i++){
			for(int j=0; j<p3.size; j++){
				p3.mat[i][j] = sc.nextInt();
			}
		}

		p3.findRelationChain();
		System.out.println(p3.count);

		sc.close();
	}
}



class Problem1{
	ArrayList<Integer> factors;
	ArrayList<ArrayList<Integer>> solution;
	int n;
	Problem1(int n){
		this.n = n;
		factors = new ArrayList<>();
		solution = new ArrayList<>();
		// findFactors();
		// helper(new ArrayList<>(), 0, 1);
	}

	public void findFactors(){
		for(int i=2; i<n; i++){
			if(n%i==0) factors.add(i);
		}
		// System.out.println(factors);
		helper(new ArrayList<>(), 0, 1);
	}

	public void helper(ArrayList<Integer> arr, int currInd, int currVal){
		// System.out.println("helper");
		if(currVal==n){
			solution.add(new ArrayList<>(arr));
			System.out.println(solution);
			return;
		}
		if(currInd>=factors.size() || currVal>n){
			return;
		}
		arr.add(factors.get(currInd));
		helper(arr, currInd, currVal*factors.get(currInd));
		arr.remove(arr.size()-1);

		helper(arr, currInd+1, currVal);
	}
}

/*Given a nokia phone,with the following dialpad.
		1 2 3
		4 5 6
		7 8 9
		* 0 #
And You are given an L band to dial the number,  
Using the L band you can dial the number as follows, 
You can start with any digit,
	if you are at digit 1, next digit you can choose {6,8}
	if you are at digit 2, next digit you can choose {7,9}
	if you are at digit 3, next digit you can choose {4,8}
	and so on..

Now your task is to find how many distinct numbers of length N you can dial.

Note: Numbers should contain only digits, no {* , #}.
Answer is modulo 1000000007.

Input Format:
-----------------
An integer N, length of numbers
 
Output Format:
------------------
Print an integer, number of distinct numbers you can dial.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
10

Explanation:
-------------
To dial a number of length 1, you can dial all digits.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
20

Explanation:
------------
To dial a number of length 2, the possible numbers are
{04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

Sample Input-3:
---------------
5

Sample Output-3:
----------------
240
 */


class Problem2{
	int MOD = 1000000007;
	int[][] next = {
        {4, 6}, {6, 8}, {7, 9}, {4, 8},
        {0, 3, 9}, {}, {0, 1, 7}, {2, 6},
        {1, 3}, {2, 4}
    };
	LinkedHashSet<String> hs;
	int n;

	Problem2(int n){
		this.n = n;
		hs = new LinkedHashSet<>();
		findDistinctNums();
	}

	public void findDistinctNums(){
		if(n==0){
			return;
		}
		for(int i=0; i<10; i++){
			hs.add(Integer.toString(i));
		}
		if(n==1) return;
		hs = helper(hs);
		
	}

	public LinkedHashSet<String> helper(LinkedHashSet<String> hs) {
		int i;
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		
		for (String s : hs) {
			i = Integer.parseInt(s.substring(s.length() - 1));
			for (int j = 0; j < next[i].length; j++) {
				lhs.add(s + next[i][j]);
			}
		}
		
		if (!lhs.isEmpty() && lhs.iterator().next().length() < n) {
			return helper(lhs);
		}

		return lhs;
	}
	
}








 /*There are P people in a Village, some of the people are relatives, others are not.
Their relationship is transitive in nature. 

For example, 
 if A is a direct relative of B, and B is a direct relative of C, 
then A is an indirect relative of C. And we define a Relation Chain is a group 
of people who are direct or indirect relatives.
 
 Given a P*P matrix R representing the relationship between people in the village. 
 If R[i][j] = 1, then the i and j persons are direct relatives with each other, 
 otherwise not. 

Your task is to findout the total number of Relation Chains among all the people.

Input Format:
-------------
Line-1 : An integer P, number of people
Next P lines : P space separated integers.

Output Format:
--------------
Print an integer, the total number of Relation Chains


Sample Input-1:
---------------
3
1 1 0
1 1 0
0 0 1

Sample Output-1:
----------------
 2

 Explanation:
 ------------
 The 0-th and 1-st people are direct relatives, so they are in a relation chain.
 The 2-nd person himself is in a relation chain. So return 2.

Sample Input-2:
---------------
3
1 1 0
1 1 1
0 1 1

Sample Output-2:
----------------
 1

Explanation:
------------
The 0-th and 1-st people are direct relatives, 1-st and 2-nd people are direct 
relatives. So, the 0-th and 2-nd people are indirect relatives.
All of them in the same relative chain. So return 1.

 */


class Problem3{
	int size;
	int[][] mat;
	int count = 0;
	int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

	Problem3(){
		System.out.println("frwjv");
	}

	class dirr{
		int i;
		int j;

		dirr(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	public void findRelationChain(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(mat[i][j]==1){
					mat = helper(mat, i, j);
				}
			}
		}

		// System.out.println(count);
	}

	public void printMat(int[][] arr){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}


	public int[][] helper(int[][] arr, int i, int j){
		Queue<dirr> que = new LinkedList<>();
		que.add(new dirr(i, j));
		arr[i][j] = 0;
		dirr curr;
		while(!que.isEmpty()){
			curr = que.poll();

			for(int k=0; k<dirs.length; k++){
				int m = curr.i+dirs[k][0];
				int n = curr.j+dirs[k][1];
				if((m>=0 && m<size) && (n>=0 && n<size) && arr[m][n] == 1){
					que.add(new dirr(m,n));
					arr[m][n] = 0;
				}
			}
		}
		count++;
		// printMat(arr);
		return arr;
	}
}