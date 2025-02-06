package PreFS;
import java.util.*;


// First
// The problem presented to the participants is to find how many zeros appear at 
// the end of the factorial of a given number, N. Factorials grow very fast, and 
// calculating them directly can be overwhelming, especially for large values of N.

// Therefore, students must use efficient strategies to determine the number of 
// trailing zeros in the factorial.

// For example, the factorial of 5 is 5!=1×2×3×4×5=120, and there 
// the end of 120. However, for N=4, the factorial 4!=24 has 0 zeros at the end.

// The Olympiad judges are looking for quick and accurate solutions, and the 
// participants are tasked with solving multiple such problems under strict time limits.

// Constraint : 
// ============
// 1<= N <= 10000


// Input Format:
// -------------
// An integer N

// Output Format:
// --------------
// Print an integer, number of 0's at the end.


// Sample Input-1:
// ---------------
// 5

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// 4

// Sample Output-2:
// ----------------
// 0




public class Day_10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // First
        // int n = sc.nextInt();
        // First.first(n);



        // Second
        // String s = sc.next();
        // String ch = sc.next();
        // Second.second(s, ch.charAt(0));

        

        // Third
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Third.third(n, arr));


        sc.close();
    }
}


class First{
    public static void first(int n){
        int count = 0;
        int powerOf5 = 5;

        while(n/powerOf5>0){
            count+=n/powerOf5;
            powerOf5*=5;
        }
        System.out.println(count);
    }
}



// Second
// Vishal is a software engineer working on the development of a new text-based game. 
// In the game, players are given a set of clues based on specific letters of the 
// alphabet, and their task is to identify the "next" letter in the sequence. To 
// enhance the game, Vishal wants to implement a feature where the next letter 
// follows the cyclic order of the alphabet, meaning after "z", the next letter 
// loops back to "a."

// He has a list of sorted letters from 'a' to 'z' that represent available clues,
// and his task is to find the next valid letter, or "successor," for a given clue. 

// For example, if the clue is "f," and the sorted list of letters is "adghijl", 
// the successor should be the smallest letter greater than "f," which is "g."

// The letters are guaranteed to be sorted in non-decreasing order, and Vishal 
// needs to solve this problem efficiently in logarithmic time.

// Your task is to help Vishal by implementing the functionality to find the successor 
// for a given letter in the sorted list of clues. If no valid successor is found, 
// the answer should wrap around cyclically to the first letter in the list.

// Input Format:
// -------------
// Line-1:A string str[]
// Line-2: a character represents an alphabet.
 
// Output Format:
// --------------
// Print a character which is the successor.
 
// Constraints:
// ------------
// 2 <= str.length<= 10^4
// 'alp' is a lowercase letter.

 
// Sample Input-1:
// ---------------
// adghijl
// f 
// Sample Output-1:
// ----------------
// g

// Sample Input-2:
// ---------------
// abcdefghi
// j

// Sample Output-2:
// ----------------
// a



class Second{
    public static void second(String s, char ch){
        int chas = (int)ch;
        int minas = (int)s.charAt(0);
        for(int i=0; i<s.length(); i++){
            int curras = (int)(s.charAt(i));
            if(chas < curras){
                minas = curras;
                break;
            }
        }

        if(minas!=0){
            System.out.println((char)minas);
        }else{
            System.out.println(s.charAt(0));
        }
    }
}







// Third
// For a Movie Premiere in US, advance booking is opened,
// At Quad Cinema theater, each ticket costs $25.
// And issue only one ticket per head. 

// People are standing in a queue to buy from Quad Cinema counter, 
// and order one at a time. And they are paying with either a $25, $50, or $100 notes.

// You will be given, an array of notes[], the people are carrying with them.
// Your task is to issue ticket and settle the balance to each person, 
// If a person given a $50 note, Issue the ticket worth $25 and settle the balance $25.

// Print true, if and only if you can provide tickets and settle the balance 
// for all the people in the queue. Otherwise, false.

// Note: Initially you don't have any amount in hand.

// Input Format:
// -------------
// Line-1: An integer N, number of persons
// Line-2: N space separated integers, notes with the persons.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 5
// 25 25 25 50 100

// Sample Output-1:
// ----------------
// true

// Explanation:
// -----------
// - The first three people pay with $25, so no change is needed.
// - The fourth person pays with $50, and you return $25 as change.
// - The fifth person pays with $100, and you return $75 as change ($50 + $25).
// - Since every person gets their ticket and correct change, the answer is true.

// Sample Input-2:
// ---------------
// 5
// 25 25 50 50 100

// Sample Output-2:
// ----------------
// false

// Explanation:
// -----------
// - The first two people pay with $25, so no change is needed.
// - The third and fourth people pay with $50, and you return $25 as change.
// - The fifth person pays with $100, but you cannot return $75 as change 
// (you only have $50 bills).
// Since not everyone can receive their correct change, the answer is false.



class Third{
    public static boolean third(int n, int[] nums){
        int n25 = 0;
        int n50 = 0;
        int n100 = 0;

        for(int i=0; i<n; i++){
            if(nums[i]==25){
                n25+=1;
            } else if(nums[i]==50){
                if(n25>0){
                    n50+=1;  n25-=1;
                }
                else return false;
            } else if(nums[i]==100){
                if(n50>0 && n25>0){
                    n100+=1;  n25-=1;  n50-=1;
                } else if(n25>=3){
                    n100+=1;
                    n25-=3;
                }
                else return false;
            }
        }
        return true;
    }
}