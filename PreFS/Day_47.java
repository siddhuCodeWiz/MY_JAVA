package PreFS;

/*A system is designed to distribute even-sized allocations for a given 
resourceLimit. The goal is to maximize the number of unique allocations 
while ensuring that their sum equals resourceLimit.

Given an integer resourceLimit, split it into a sum of a maximum number of 
unique positive even integers. The following conditions must be met:
    - Each allocation must be a unique positive even integer.
    - The total sum of the integers must equal resourceLimit.
    - The number of integers in the split must be maximized.
    
If it is not possible to split resourceLimit into valid even allocations, 
return an empty list.

Input Format:
-------------
A single integer, resourceLimit (1 ≤ resourceLimit ≤ 10^9).

Output Format:
--------------
A list of integers representing the allocations. 
If no valid allocations exist, return an empty list.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[2, 4, 6]

Explanation:
------------
The possible splits are:
    - [12] (1 allocation)
    - [2, 10] (2 allocations)
    - [2, 4, 6] (3 allocations)
The split [2, 4, 6] has the maximum number of allocations.


Sample Input-2:
---------------
7

Sample Output-2:
----------------
[]

Explanation: 
------------
It's not possible to split 7 into unique positive even integers.

Sample Input-3:
---------------
28

Sample Output-3:
----------------
[2, 4, 6, 16]

Explanation: 
The possible splits are:
    - [2, 26] (2 allocations)
    - [6, 8, 2, 12] (4 allocations)
    - [2, 4, 6, 16] (4 allocations)

The split [2, 4, 6, 16] has the maximum number of allocations.

NOTE:
=====
Please refer the sample outputs to generate the solution. */
import java.util.*;

public class Day_47 {
    public static ArrayList<Integer> sols = new ArrayList<>();
    public static int sizeee = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // maxNums(n, 0, 0, new ArrayList<>());

        // System.out.println(sols);



        // Program 2
        Program2 p2 = new Program2();
        p2.s = sc.nextLine();
        p2.distinctWords(p2.s, new StringBuilder(""), 0);
        System.out.println(p2.sols);
        System.out.println(p2.sols.size());
    }





    public static void maxNums(int n, int currSum, int currNum, ArrayList<Integer> currNums){
        if(currSum==n){
            System.out.println(currNums+"  "+currSum);
            if(currNums.size() > sizeee){
                sols = new ArrayList<>(currNums);
                sizeee = currNums.size();
            }
            return;
        }

        if(currSum>n || currNum>=n){
            return;
        }

        // maxNums(n, currSum, currNums);

        int kk = currNum+1;
        while(kk%2!=0){
            kk++;
        }
        currNums.add(kk);
        maxNums(n, currSum+kk, kk , currNums);
        currNums.remove(currNums.size()-1);
        maxNums(n, currSum, kk,currNums);


    }

}









/*There are some cubes, and each cube has an alphabet (from A to Z) 
printed on it. You can construct different, non-empty words using these 
cubes and each of the word length should be 0 < length <= number of cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89 */


class Program2{
    String s;
    HashSet<String> sols = new HashSet<>();

    public void distinctWords(String s, StringBuilder curr, int index){
        if(curr.length()>0){
            sols.add(curr.toString());
        }

        for(int i=index; i<s.length(); i++){
            curr.append(s.charAt(i));

            distinctWords(s, curr, i+1);

            curr.deleteCharAt(curr.length()-1);
        }
    }
}