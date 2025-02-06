package PreFS;

/*A family is about to break their piggy bank to use the money for different 
purposes. The piggy bank is represented as an array (`arr[]`) consisting of 
`M` coins. The family needs to split the coins in the piggy bank into smaller 
stacks (sub-arrays) such that the **sum of the differences between the maximum 
value and the minimum value of the coins in all the stacks (sub-arrays) is 
maximum. 

Constraints:
- Each value in the array can only be used once, i.e., it can belong to only 
  one sub-array.
- You are not allowed to change the order of the elements in the array.

Input Format:
-------------
5
8 9 7 1 2

Output Format:
-------------
7

Sample Input-1:
---------------
5
8 9 7 1 2

Sample Output-1:
----------------
8

Explanation:
------------
Sub-array [8]: Difference = 0 (a single element has no difference).
Sub-array [9, 7, 1]: Difference = 9 - 1 = 8
Sub-array [2]: Difference = 0 (a single element has no difference).


Sample Input-2:
---------------
5
8 1 7 9 2

Sample Output-2:
----------------
14

 */
import java.util.*;
public class Day_46 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // Program 2
      // Program2 p2 = new Program2();
      // p2.S = sc.nextLine();
      // p2.findPalindromes();


      // Program 3
      Program3 p3 = new Program3();
      p3.n = sc.nextInt();
      p3.k = sc.nextInt();
      p3.arr = new int[p3.n];
      for(int i=0; i<p3.n; i++){
        p3.arr[i] = sc.nextInt();
      }

      p3.findMin();
    }
}



/*Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found.

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid


Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f. */


class Program2{
  String S;
  int count=0;

  public boolean isPalindrome(String f){
    for(int i=0; i<=f.length()/2; i++){
      if(f.charAt(i) != f.charAt(f.length()-1-i)){
        return false;
      }
    }
    return true;
  }

  public void findPalindromes(){
    // for(int i=0; i<S.length(); i++){
    //   for(int j=i+1; j<=S.length(); j++){
    //     if(isPalindrome(S.substring(i, j))){
    //       // System.out.println(S.substring(i, j));
    //       count++;
    //     }
    //   }
    // }


    for(int i=0; i<S.length(); i++){
      int left = i, right = i;

      while(left>=0 && right<S.length() && S.charAt(left)==S.charAt(right)){
        count++;
        left-=1;
        right+=1;
      }

      left = i; right = i+1;
      while(left>=0 && right<S.length() && S.charAt(left)==S.charAt(right)){
        count++;
        left-=1;
        right+=1;
      }
    }

    System.out.println(count);
  }
}





/*You are tasked with calculating the minimum cost to travel between a series of 
buildings arranged in a straight line. There are n buildings, numbered from 1 
to n, and each building has an associated cost. 

The cost represents the expense incurred when you stop at a particular building.

You are allowed to jump between buildings, but the maximum jump length is limited
to k buildings. Whenever you stop at a building, the cost of that building is 
added to your total cost. The objective is to determine the minimum total cost 
required to travel all the buildings from the first building to the n-th 
(destination) building. Initially you are at 0th position, and the first building
starts at 1st position.

Input Format:
-------------
Two space separated integers, N and K.
N space separated integers, costs[], to reach buildings.

Output Format:
--------------
An integer result, minimum total cost.


Sample Input-1:
---------------
5 2
4 3 9 3 1

Sample Output-1:
----------------
7


Sample Input-2:
---------------
6 3
10 30 40 50 20 10

Sample Output-2:
----------------
60
 */


class Program3{
  int n;
  int k;
  int[] arr;
  int minCost = Integer.MAX_VALUE;

  public void findMin(){
    for(int i=0; i<k; i++){
      helper(i, arr[k]);
    }

    System.out.println(minCost);
  }

  public void helper(int currInd, int cost){
    if(currInd==n-1){
      minCost = Math.min(minCost, cost);
      return;
    }
    if(currInd>=n){
      return;
    }

    for(int i=1; i<=k; i++){
      if(currInd+i < n){
        // System.out.println((cost+arr[currInd+i])+" "+(currInd+i));
        helper(currInd+i, cost+arr[currInd+i]);
      }
    }
  }
}









/*The process of initiating an action on a server is done through HTTP requests, 
which are messages sent by the client. The two most commonly used HTTP 
requests are GET and POST. This task involves validating requests and parsing 
URL parameters as a comma-separated string.

Authentication Tokens:
	- For both GET and POST requests, authentication tokens are sent as a 
	  URL parameter named "token".
	- Validation ensures that the token belongs to a predefined set of valid tokens.

POST Requests:
Additionally, a valid POST request requires a CSRF token, which:
	- Must be an alphanumeric value.
	- Have a length of at most 8.
	
URL Parsing:
URL parameters consist of key-value pairs separated by an equal sign = and 
multiple parameters separated by an ampersand &. 

For example:
https://example.com?param1=value1&param2=value2

If the request is valid, return VALID followed by the parsed URL parameters in 
a comma-separated string:  VALID, name=value1, id=value2
If invalid, return INVALID

Input Format:
-------------
Two space separated integers, M and N
M lines: a string, valid token
N Lines: comma separated strings, method-type and url-paramater

Output Format:
--------------
N lines of output according to problem statement.

Sample Input-1:
---------------
3 2
et51u819p1q7
b8nn5j4om76v
r5b6191mlp09
GET,https://example.com?token=et51u819p1q7&id=23r&name=alex
POST,https://example.com?token=r5b6191mlp09&csrf=f1a098idu78&name=evan

Sample Output-1:
----------------
VALID, name=alex, id=23r
INVALID


Sample Input-2:
---------------
5 3
acg71288bybi
rkifz4hkzy3k
1ezzh1gyfswh
hrmkv5b1f7qr
mvf1pk83na47
GET,https://example.com?token=mvf1pk83na47&id=0x6&name=xmit
POST,https://example.com?token=rkifz4hkzy3k&id=int&name=7ad6
POST,https://example.com?token=1ezzh1gyfswh&id=u82&name=tu7d&csrf=kx0ccyvu

Sample Output-2:
----------------
VALID, name=xmit, id=0x6
INVALID
VALID, name=tu7d, id=u82 */

class Program4{

}