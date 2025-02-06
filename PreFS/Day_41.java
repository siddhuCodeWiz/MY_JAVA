package PreFS;

/*
Ramesh and Suresh are playing a game.
Initially, Ramesh has a secret number, and Suresh has to guess that number.
Ramesh now checks, How many digits of the guess number match 
the secret number exactly, if both the digit and position are matched, 
indicate them as Apples. If the digit is matched and position is different, 
indicate them as Bananas.

Ramesh will give a hint to Suresh as follows:
e.g., secret number= 1231, and guess number = 4213
Only digit=2 is matching, so apple is 1, banana is 2
Ramesh tell the answer as 1A2B

You are given secrect number and guess number as strings,
Your task to help Ramesh, to find and return the HINT.

NOTE: The length of the both secrect and guess number is same, 
		contains only digits.

Input Format:
-------------
Two strings, secret and guess

Output Format:
--------------
Print the string, the HINT.


Sample Input-1:
---------------
1807 7810

Sample Output-1:
----------------
1A3B

Explanation: 
------------
1 Apple and 3 Banana. Apple is 8, Banana are 0, 1 and 7.


Sample Input-2:
---------------
1123 0111

Sample Output-2:
----------------
1A1B

Explanation: 
------------
The 1st 1 in Suresh guess is an Apple, the 2nd or 3rd 1 is B.

*/


import java.util.*;

public class Day_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program1 p1 = new Program1();
        p1.secret = sc.nextInt();
        p1.guess = sc.nextInt();

        System.out.println(p1.findHint());

        sc.close();
    }
}

class Program1{
    int secret;
    int guess;

    public void printtt(String[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }

    public String findHint(){
        int apples = 0;
        int bananas = 0;

        String[] sec = Integer.toString(secret).split("");
        String[] gue = Integer.toString(guess).split("");

        for(int i=0; i<gue.length; i++){
            System.out.print(i+"--->");
            if(gue[i].equals(sec[i])){
                apples++;
                sec[i]="_";
            }
            else{
                for(int j=0; j<sec.length; j++){
                    if(gue[i].equals(sec[j])){
                        bananas++;
                        sec[j]="_";
                        break;
                    }
                }
            }
            printtt(sec);
        }
        String ans = apples+"A"+bananas+"B";
        return ans;
    }
}



/*
 * Mr Ravi is a business man, he does business weekly Q times, 
and records his PROFIT or LOSS every time in to data[][] array. 
He records the LOSS as a negative value and PROFIT as a positive value.

Your task is to help Mr Ravi to know that how many total number of times,
he was in LOSS after P weeks.

NOTE: The values in data[][] are in descending order both row-wise and 
column-wise as given in sample testcases.

Input Format:
-------------
Line-1: Two space separated integers, P and Q
Next P lines: Q space separated integers, data[][].   

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4 4
5 4 2 -2
4 3 1 -2
2 2 -1 -3
-1 -1 -2 -4

Sample Output-1: 
----------------
8

Explanation: 
------------
8 days in LOSS,since there are 8 negative values.

Sample Input-2:
---------------
4 4
8 7 1 -2
7 6 2 -3
3 -1 -2 -4
-2 -3 -4 -7
	 
Sample Output-2:
----------------
9

Explanation:
------------
9 days in LOSS,since there are 8 negative values.

Sample Input-3:
---------------
2 2
9 3
5 0

Sample Output-3:
----------------
0

 */