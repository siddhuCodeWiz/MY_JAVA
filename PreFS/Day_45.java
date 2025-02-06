package PreFS;
/*Mr Govind is working with words in English.
He found something interesting between the words.
The properties of those words are as follows:
	- The words have same set of letters and occurrences of each letter is also same.
	- For example, read and dear are the two words having same letters,
	and each letter appeared for same number of times in each word.
	- Only the positions of the letters may vary in the words.

You will be given the list of words, Your task is to find and
group the words which have the properties mentioned above.
And print them as list of list of words as shown in the samples. 

Input Format:
-------------
Line-1: A single line space space-separated words, list[].

Output Format:
--------------
Print the list of list of strings.


Sample Input-1:
---------------
tear tera dare dear read rate tare earn near rena

Sample Output-1:
----------------
[[tear, tera, rate, tare], [dare, dear, read], [earn, near, rena]]


Sample Input-2:
---------------
rate tar eat tare tear tea rat

Sample Output-2:
----------------
[[rate, tare, tear], [tar, rat], [eat, tea]]
 */
import java.util.*;

public class Day_45 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Program 1
      // Program1 p1 = new Program1();
      // String s = sc.nextLine();
      // p1.arr = s.split(" ");
      // p1.findSimilar();
      



      // Program2
      // Program2 p2 = new Program2();
      // p2.TP = sc.nextInt();
      // p2.TA = sc.nextInt();
      // p2.TS = sc.nextInt();

      // p2.findMin();



      // Program 3
      Program3 p3 = new Program3();
      p3.N = sc.nextInt();
      p3.L = sc.nextInt();
      p3.U = sc.nextInt();

      p3.arr = new int[p3.N];

      for(int i=0; i<p3.N; i++){
        p3.arr[i]=sc.nextInt();
      }

      p3.findArrays();
    }
}

class Program1{
  String[] arr;
  LinkedHashMap<String, ArrayList<String>> hm = new LinkedHashMap<>();

  public void findSimilar(){
    for(int i=0; i<arr.length; i++){
      String tem = arr[i];
      char[] temp = arr[i].toCharArray();
      Arrays.sort(temp);

      String sortedString = new String(temp);

      if(hm.containsKey(sortedString)){
        hm.get(sortedString).add(tem);
      }else{
        ArrayList<String> a = new ArrayList<>();
        a.add(tem);
        hm.put(sortedString, a);
      }
    }

    ArrayList<ArrayList<String>> sols = new ArrayList<>();
    for(ArrayList<String> sol : hm.values()){
      sols.add(sol);
    }

    System.out.println(sols);
  }
}


/*In a prestigious Collaborative Innovation Summit, there are two key sessions: 
Artificial Intelligence (AI) and Sustainability (SUS). Teams for these sessions 
must adhere to strict size requirements:
    - Session AI: Each team participating in this session must have exactly 
      'TA' members.
    - Session SUS: Each team participating in this session must have exactly 
      'TS' members.

The total number of participants attending the summit is TP.

Your task is to determine the minimum number of teams needed to accommodate all 
participants such that:
    - Each participant is assigned to exactly one team.
    - Each team confirms to the size requirements of either the AI or the SUS 
      session.
If it is not possible to assign all participants into teams while meeting these 
criteria, return -1.

Input Format:
-------------
Three space sepaarted integers, TP, TA, TS

Output Format:
--------------
A single integer representing the minimum number of teams required to allocate 
all participants


Sample Input-1:
---------------
50 5 8

Sample Output-1:
----------------
7

Explanation:
------------
5 teams of size 8 → 5×8=40 participants.
2 teams of size 5 → 2×5=10 participants.
The total is: 40+10=50 (Total:50 participants,all accounted for).


Sample Input-2:
---------------
23 5 6

Sample Output-2:
----------------
4

Explanation:
------------
3 teams of size 6 → 3×6=18 participants.
1 teams of size 5 → 1×5=5 participants.
The total is: 18+5=23 (Total:23 participants,all accounted for).
 */

class Program2{
  int TP, TA, TS;
  int count = Integer.MAX_VALUE;

  public void findMin(){
    int maxxx = Math.max(TP/TA, TP/TS);
    int ma = Math.max(TS, TA);
    int minnn = Math.min(TP/TA, TP/TS);
    int mi = Math.min(TS, TA);

    System.out.println(maxxx+" "+minnn);

    for(int i=minnn; i>=1; i--){
      int remPat = TP;
      int c=0;
      remPat-=(i*ma);
      c+=i;
      for(int j=1; j<=maxxx; j++){
        if(remPat-(j*mi)==0){
          c+=j;
          count=Math.min(count, c);
        }
      }
    }
    System.out.println(count);
  }
}







/*A covert agent has crucial information stored in the form of an array of integers. 
The array contains sensitive information, and it must not be revealed to anyone. 
However, certain properties about the array are known:
 - The length of the array is equal to the "length of a secret array + 1".
 - Each integer in the array lies within a specific interval [lowerBound L,
   upperBound U ].
 
The difference between each pair of consecutive integers in the array must be equal
to the difference between the respective pair of integers in the secret array.

Given a list of consecutive differences representing the secret array.
The values of lowerBound and upperBound.

Your task is to find the total number of arrays that satisfy the conditions to 
be analogous to the secret array. If no such arrays exist, return 0.

Input Format:
-------------
Three space sepaarted integers, N, L, U
N space serapated inteegrs, secret array[].

Output Format:
--------------
An integers, number of analogous arrays.


Sample Input-1:
---------------
4 3 10
-2 -1 -2 5

Sample Output-1:
----------------
3

Explanation:
--------------
There are 3 valid arrays:
    [3, 5, 6, 8, 3]
    [4, 6, 7, 9, 4]
    [5, 7, 8, 10, 5]


Sample Input-2:
---------------
3 1 6
1 2 1

Sample Output-2:
----------------
2

Explanation:
------------
There are 2 valid arrays:
    [1, 2, 4, 5]
    [2, 3, 5, 6]
 */



class Program3{
  int N, U, L;
  int[] arr;
  ArrayList<ArrayList<Integer>> sols = new ArrayList<>();

  public void findArrays(){
    ArrayList<Integer> sol;
    for(int i=L; i<=U; i++){
      sol = new ArrayList<>();
      sol.add(i);
      helper(0, i, sol);
    }

    for(ArrayList<Integer> s : sols){
      System.out.println(s);
    }

    System.out.println(sols.size());
  }

  public void helper(int currInd, int currVal, ArrayList<Integer> sol){
    if(currInd==N){
      sols.add(sol);
      return;
    }

    if(currVal+arr[currInd]>U || currVal+arr[currInd]<L){
      return;
    } else{
      sol.add(currVal+arr[currInd]);
      helper(currInd+1, currVal+arr[currInd], sol);
    }
  }
}