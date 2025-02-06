package PreFS;

/*/*
There are N rooms in a row, and all the rooms are locked initially.
You will be provided the master key. You can use the master key only once, and
you can unlock any one room and find a key in it of some other room. 
You have to repeat this process until you can find the keys of the locked rooms. 
You have to stop this process once you find the key of a room 
which is already unlocked.

You are given an array of keys[], where i-th room contains the key of key[i]-th
room and values of keys[] are range from [0..N-1] without duplicates. Your task 
is to find the maximum number of rooms can be unlocked including the first room.

Input Format:
-------------
Line-1: An integer N, number of rooms.
Line-2: N space separated integers, keys of rooms.

Output Format:
--------------
Print an integer result.
 
Sample Input-1:
---------------
8
7 4 6 2 1 0 3 5

Sample Output-1:
----------------
3

Explanation:
-----------
keys[0] = 7, keys[1] = 4, keys[2] = 6, keys[3] = 2, keys[4] = 1, keys[5] = 0, 
keys[6] = 3, keys[7]=5.

You can start with Room-0 using the master key, you can open the following rooms:
  key[0]=7 =>  key[7]=5  =>  key[5]=0
          or
  key[2]=6 =>  key[6]=3  =>  key[3]=2

You can unlock maximum 3 rooms.

Sample Input-2:
---------------
 6
 3 2 4 0 5 1

 Sample Output-2:
 ----------------
 4
 
Sample Input-3:
---------------
5
0 1 2 3 4

 Sample Output-3:
----------------
1
*/
import java.util.*;
public class Day_36 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // Problem 1
      // Problem1 p1 = new Problem1();
      // p1.n = sc.nextInt();
      // p1.arr = new int[p1.n];
      // for(int i=0; i<p1.n; i++){
      //   p1.arr[i] = sc.nextInt();
      // }
      // p1.calMaxxx();
      // System.out.println(p1.maxxx);



      // Problem 2
      // Program2 p2 = new Program2();
      // p2.n = sc.nextInt();
      // sc.nextLine();
      // for(int i=0; i<p2.n; i++){
      //   String[] lll = sc.nextLine().split(" ");
      //   p2.hm.put(lll[0], lll[1]);
      // }
      // p2.s = sc.nextLine();

      // p2.findCombs();



      // Program 3
      Program3 p3 = new Program3();
      p3.N = sc.nextInt();
      p3.F = sc.nextInt();
      p3.arr = new int[p3.N];
      for(int i=0; i<p3.N; i++){
        p3.arr[i] = sc.nextInt();
      }
      p3.findWays();
      System.out.println(p3.count);

      sc.close();
    }
}



class Problem1{
  int n;
  int[] arr;
  int maxxx = Integer.MIN_VALUE;

  public void calMaxxx(){
    boolean[] visited = new boolean[n];

    for(int i=0; i<n; i++){
      helper(i, visited, 0);
    }
  }

  public void helper(int currInd, boolean[] visited, int count){
    if(visited[currInd]==true){
      maxxx = Math.max(maxxx, count);
      // System.out.println(maxxx);
      return;
    }
    visited[currInd] = true;
    helper(arr[currInd], visited, count+1);
  }
}



/*Mr Ajay Sharma is working woth words.
He found that few words in the langugage have same meaning.
Such words are given as a list of pairs as mappedpairs[],
where mappedpairs[i] = [word1, word2] indicates that word1 and word2 are 
the words with same meaning.

He is given phrase, and he wants to apply all the mappedpairs[] on the phrase.

Your task is to help Mr.Ajay Sharma to find and return all possible 
Mapped Phrases generated after applying all the mapped words,
and print them in lexicographical order.


Input Format:
-------------
Line-1: An integer N, number of mapped pairs.
Next N lines: Two space separated words, mappedpair[].
Last Line: A line of words, the phrase.

Output Format:
--------------
Print the list of mapped phrases in sorted order.


Sample Input-1:
---------------
3
hi hello
sweet sugar
candy chocolate
hi sam! ram has a sugar candy

Sample Output-1:
----------------
[hello sam! he has sugar candy, hello sam! he has sugar chocolate, 
hello sam! he has sweet candy, hello sam! he has sweet chocolate, 
hi sam! he has sugar candy, hi sam! he has sugar chocolate, 
hi sam! he has sweet candy, hi sam! he has sweet chocolate]



Sample Input-2:
---------------
2
hi hey
hey hello
hi how are you

Sample Output-2:
----------------
[hello how are you, hey how are you, hi how are you] */


class Program2{
    HashMap<String, String> hm = new HashMap<>();
    String s;
    int n;
    HashSet<String[]> sols = new HashSet<>();

    public void findCombs(){
      String[] ss = s.split(" ");
      helper(ss);
    }

    void printHm(){
      for(String[] i : sols){
        for(String j : i){
          System.out.print(j+" ");
        }
        System.out.println();
      }
    }

    public void helper(String[] curr){
      sols.add(curr);
      // System.out.println("ewnjs");
      printHm();
      // System.out.println(sols);
      for(int i=0; i<curr.length; i++){
        if(hm.containsKey(curr[i])){
          curr[i] = hm.get(curr[i]);
          helper(curr);
        } if(hm.containsValue(curr[i])){
          curr[i] = hm.get(curr[i]);
        }
      }
    }
}








/*You are given a set of N integers, and a value to find F. Initially a variable, 
'total' is set to 0. You can perform either addition(+) or subtraction(-)
of every integer from the set to the 'total'. The resultant total should be
equal to the value F.

Your task is to find out the number of ways, you can make the 'total' equal to
the value F.

Input Format:
-------------
Line-1: Two integers N and F.
Line-2: N space separated integers 

Output Format:
--------------
Print an integer, number of ways.


Sample Input:
---------------
5 3
1 1 1 1 1

Sample Output:
----------------
5

Explanation:
------------
total = -1+1+1+1+1 = 3 -> total=value-F
total = +1-1+1+1+1 = 3 -> total=value-F
total = +1+1-1+1+1 = 3 -> total=value-F
total = +1+1+1-1+1 = 3 -> total=value-F
total = +1+1+1+1-1 = 3 -> total=value-F

NOTE: + means addition, - means subtraction */


class Program3{
  int N;
  int F;
  int[] arr;
  int count=0;

  public void findWays(){
    helper(0, 0);
  }


  public void helper(int ind, int currVal){
    if(ind>=N){
      if(currVal==F) count++;
      return;
    }

    helper(ind+1, currVal+arr[ind]);
    helper(ind+1, currVal-arr[ind]);
  }
}