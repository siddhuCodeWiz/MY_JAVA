package PreFS;
import java.util.*;


// Question 1
// You are given an array of integers called 'score,' containing 'n' elements, 
// where 'score[i]' represents the performance score of the ith participant in a 
// competitive event. The scores are guaranteed to be unique.

// The participants' final rankings are based on their performance scores, with 
// the top performer (the one with the highest score) securing the 1st place, 
// the second-highest scorer obtaining the 2nd place, and so on. Each participant's 
// rank is directly associated with their position:
//  - The participant in the 1st place is awarded the rank "Champion".
//  - The participant in the 2nd place is awarded the rank "RunnerUp-1".
//  - The participant in the 3rd place is awarded the rank "RunnerUp-2".
//  - For participants in the 4th place to the nth place, their rank corresponds to 
//    their position (i.e., the participant in the x-th position is assigned the rank 'x').

// Your task is to generate an array called 'answer' of size 'n'. Each element 
// 'answer[i]' in this array should represent the rank achieved by the i-th 
// participant based on their performance score.

// Input Format:
// -------------
// Line-1: An integer N, number of participants.
// Line-2: N space seprated integers, scores[].

// Output Format:
// --------------
// Print the list of ranks of the participants.


// Sample Input-1:
// ---------------
// 5
// 10 3 9 8 4

// Sample Output-1:
// ----------------
// [Champion, 5, RunnerUp-1, RunnerUp-2, 4]


// Sample Input-2:
// ---------------
// 8
// 10 3 9 4 2 7 6 1

// Sample Output-2:
// ----------------
// [Champion, 6, RunnerUp-1, 5, 7, RunnerUp-2, 4, 8]




public class Day_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // First
        // int n = sc.nextInt();
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     arr.add(sc.nextInt());
        // }
        // First.first(n, arr);




        // Second
        // String s = sc.nextLine();
        // String[] arr = s.split(" ");
        // Second.second(arr);



        // Third
        // int[][] arr = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {0, 0, 0, 0, 1}};
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Third.third(m, n, arr);

        sc.close();
    }
}








class First{
    public static void first(int n, ArrayList<Integer> arr){
        ArrayList<Integer> narr = new ArrayList<>(arr);
        Collections.sort(narr, Collections.reverseOrder());

        LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();

        for(int i=0; i<arr.size(); i++){
            if(i==0){
                hm.put(narr.get(i), "Champion");
            } else if(i==1){
                hm.put(narr.get(i), "RunnerUp-1");
            } else if(i==2){
                hm.put(narr.get(i), "RunnerUp-2");
            } else{
                hm.put(narr.get(i), ""+(i+1));
            }
        }

        ArrayList<String> solution = new ArrayList<>();
        for(int i=0; i<arr.size(); i++){
            solution.add(hm.get(arr.get(i)));
        }

        System.out.println(solution);
    }
}






// Question 2
// You are tasked with building a communication system where text messages are encoded using 
// these symbol sequences. You are developing an encoding system that converts words into a 
// secret code using a specific set of predefined symbols. Each letter of the English alphabet 
// is mapped to a unique sequence of symbols, where - and / are used to represent different 
// elements. The entire alphabet has been mapped to these unique sequences.

// Here is the mapping for each letter:
// ["/-", "/---", "/-/-", "/--", "-", "--/", "//-", "----", "--", "-///", "/-/", "-/-/", "//", 
// "/-", "---", "/--/", "//-/", "/-/", "---", "/", "--/", "---/", "/--", "/--/", "/-//", "//--"]

// Given an array words, messages[], each word can be encoded by converting each letter into its
// corresponding symbol sequence and concatenating them together.

// For example, the word "data" might transform into a code like /---/--/ where each letter is 
// replaced by its corresponding symbol sequence. Your goal is to determine how many distinct 
// encoded messages are generated from a list of words.

// Input Format:
// -------------
// space separated strings, messages[].

// Output Format:
// --------------
// An integer, number of distinct encoded messages.


// Sample Input-1:
// ---------------
// gin zen gig msg

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// abc def ghi

// Sample Output-2:
// ----------------
// 3


class Second{
    public static void second(String[] arr){
        String[] sols = {"/-", "/---", "/-/-", "/--", "-", "--/", "//-", "----", "--", "-///", "/-/", "-/-/", "//","/-", "---", "/--/", "//-/", "/-/", "---", "/", "--/", "---/", "/--", "/--/", "/-//", "//--"};
        HashMap<Character, String> hm = new HashMap<>();

        for(int i=0; i<sols.length; i++){
            hm.put((char)(i+97), sols[i]);
        }

        ArrayList<String> codes = new ArrayList<>();
        // ArrayList<String> codes = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<arr[i].length(); j++){
                sb.append(hm.get(arr[i].charAt(j)));
            }
            if(!codes.contains(sb.toString())){
                codes.add(sb.toString());
            }
        }
        System.out.println(codes.size());
    }
}





// Question 3
// To maximize energy efficiency and lighting optimization, you are allowed to perform 
// an operation multiple times:
// 	You can choose any row or column of the grid and toggle all the bulbs in 
// 	that row or column. Toggling means:
// 		- Bulbs that are ON (1) will turn OFF (0).
// 		- Bulbs that are OFF (0) will turn ON (1).

// Each row in the grid can be interpreted as a binary number, where the leftmost bulb 
// is the most significant bit and the rightmost bulb is the least significant bit. 
// The goal is to maximize the sum of these binary numbers for all rows in the grid, 
// after performing any number of toggles on the grid.

// Your task is to find the highest possible score, which is the maximum sum of all 
// the binary numbers that can be obtained after optimizing the grid through these 
// toggling operations.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N
// Next M lines: N space separated integers, grid[][]

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 3 5
// 0 1 1 1 1 
// 1 0 1 1 1 
// 0 0 0 0 1 

// Sample Output-1:
// ----------------
// 78

// Explanation:
// ------------
// Given grid is 
// 0 1 1 1 1
// 1 0 1 1 1
// 0 0 0 0 1

// Perform operation on row-0 and row-2
// 1 0 0 0 0
// 1 0 1 1 1
// 1 1 1 1 0

// Perform operation on col-1 and col-4
// 1 1 0 0 1 = 25
// 1 1 1 1 0 = 30
// 1 0 1 1 1 = 23
// So, now the total value of Binary Equivalent is 78


// Sample Input-2:
// ---------------
// 2 3
// 0 1 0
// 0 0 1

// Sample Output-2:
// ----------------
// 11




class Third{
    public static int countOnes(int c, int n, int[][] arr){
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i][c]==1){
                count++;
            }
        }
        return count;
    }
    public static int calValue(int m, int n, int[][] arr){
        int totalSum = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                if(arr[i][j]==1){
                    sum+=Math.pow(2, ((n-1)-j));
                }
            }
            // System.out.println(sum);
            totalSum+=sum;
        }
        return totalSum;
    }
    public static void third(int m, int n, int[][] arr){
        // int[][] narr = new int[m][n];

        for(int i=0; i<m; i++){
            if(arr[i][0]==0){
                for(int j=0; j<n; j++){
                    if(arr[i][j]==0) arr[i][j]=1;
                    else arr[i][j]=0;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(countOnes(i, m, arr) <= m/2){
                for(int j=0; j<m; j++){
                    if(arr[j][i]==0) arr[j][i]=1;
                    else arr[j][i]=0;
                }
            }
        }

        System.out.println(calValue(m, n, arr));
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
}