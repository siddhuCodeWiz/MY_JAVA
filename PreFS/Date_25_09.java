package PreFS;

// In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
// 	- Zone 1: Letters on the top row: "qwertyuiop"
// 	- Zone 2: Letters on the middle row: "asdfghjkl"
// 	- Zone 3: Letters on the bottom row: "zxcvbnm"

// Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

// Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

// Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

// Constraints:
// ------------
// 1 ≤ secretCodes.length ≤ 20
// 1 ≤ secretCodes[i].length ≤ 100
// secretCodes[i] consists of English letters (both lowercase and uppercase).

// Input Format:
// -------------
// Space separated words, secretCodes[]

// Output Format:
// --------------
// A list of codes that can be typed using letters from only one zone.


// Sample Input-1:
// ---------------
// Galaxy Mars Venus Sky

// Sample Output-1:
// ----------------
// ["Mars", "Sky"]

// Explanation:
// ------------
// "Mars" can be typed using only Zone 2.
// "Sky" can be typed using only Zone 3.
// "Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


// Sample Input-2:
// ---------------
// keyboard monkey

// Sample Output-2:
// ----------------
// []

// Explanation:
// ------------
// None of the words can be typed using letters from only one zone.


// Sample Input-3:
// ---------------
// qw er ty

// Sample Output-3:
// ----------------
// ["qw", "er", "ty"]

// Explanation:
// ------------
// All the codes can be typed using only letters from Zone 1.

import java.util.*;

public class Date_25_09 {
    public boolean isSecretCode(String[] arr){
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int used;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                
            }
        }


    }
    public static void main(String[] args) {
        System.out.println("1st Question");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");

    }
}




// In a treasure hunt adventure, you are tasked with finding a hidden treasure 
// buried somewhere along a path of numbered stones. The stones are numbered 
// sequentially from 1 to n, and you need to guess where the treasure is buried. 
// Each guess you make represents a numbered stone on the path.

// Your guide will help you by giving you hints after each guess:
// 	- If your guess is higher than the treasure's location, 
// 	  the guide will tell you to "look lower."
// 	- If your guess is lower than the treasure's location, 
// 	  the guide will tell you to "look higher."
// 	- If your guess is correct, the guide will confirm that 
// 	  you've found the treasure!

// You are provided with a pre-defined hint API called int giveHint(int guess), 
// which will return one of the following results:

// 	-1: The treasure is located at a lower-numbered stone than the guessed stone 
// 	    (i.e., guess > treasure).
// 	 1: The treasure is located at a higher-numbered stone than the guessed stone 
// 	    (i.e., guess < treasure).
//  	 0: You've found the treasure (i.e., guess == treasure).

// Your task is to determine at which numbered stone the treasure is buried.

// NOTE:
// -----
// You need to implement the method "int yourGuess(int n)" in class Solution.

// Input Format:
// -------------
// Two space separated integers, N and P

// Output Format:
// --------------
// Print the value of P.


// Sample Input-1:
// ---------------
// 21 18

// Sample Output-1:
// ----------------
// 18


// Sample Input-2:
// ---------------
// 21 3

// Sample Output-2:
// ----------------
// 3
