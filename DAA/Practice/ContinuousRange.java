package DAA.Practice;


// You are given a sorted list of integers with no duplicates. 
// Your task is to find and group continuous ranges of numbers. 
// Each group should represent the smallest and largest numbers in the continuous range using the format start->end. 
// If a number does not belong to any range (i.e., it stands alone), it should be added as a single number without the -> symbol.

// Input Format:
// -------------
// Line-1: A single line containing space-separated integers in sorted order.

// Output Format:
// --------------
// Line-1: Print a list of continuous ranges, where each range is represented as start->end for continuous numbers or as a single number if no range exists.

// Constraints:
// -------------
// -The input list contains no duplicates.
// -The list is sorted in ascending order.
// -The list may contain only a single number or multiple numbers that form various continuous ranges.

// Sample Input-1:
// ---------------
// 1 2 4 5 7

// Sample Output-1:
// ----------------
// [1->2, 4->5, 7]

// Explanation:
// ------------
// The numbers 1 and 2 form a continuous range, represented as 1->2.
// The numbers 4 and 5 form another continuous range, represented as 4->5.
// The number 7 stands alone.

// Sample Input-2:
// ---------------
// 1 2 3 5 6 7 9 10 12

// Sample Output-2:
// ----------------
// [1->3, 5->7, 9->10, 12]

// Explanation:
// -------------
// The numbers 1, 2, and 3 form a continuous range, represented as 1->3.
// The numbers 5, 6, and 7 form another continuous range, represented as 5->7.
// The numbers 9 and 10 form another range.
// The number 12 stands alone.

// Sample Input-3:
// ---------------
// 1 3 5 7 9

// Sample Output-3:
// ----------------
// [1, 3, 5, 7, 9]

// Explanation:
// -------------
// All numbers in this list stand alone, so they are printed individually.

import java.util.*;
public class ContinuousRange {

    public static void mergeRange(ArrayList<Integer> l){
        ArrayList<String> sol = new ArrayList<>();
        StringBuilder temp;
        for(int i=0; i<l.size(); i++){
            temp = new StringBuilder("");
            temp.append(l.get(i));
            boolean entered = false;
            // System.out.println(l.get(i)+" "+l.get(i+1)+1);
            while(i<l.size()-1 && (l.get(i)+1 == l.get(i+1))){
                i++;
                entered = true;
                // System.out.println("entered");
            }

            if(entered==true){
                temp.append("->"+l.get(i));
            }
            sol.add(temp.toString());
        }
        System.out.println(sol);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] l = s.split(" ");
        ArrayList<Integer> ar = new ArrayList<>();


        for(int i=0; i<l.length; i++){
            ar.add(Integer.parseInt(l[i]));
        }
        mergeRange(ar);
        // System.out.println("2"+0==("1"+1));
    }
}
