package DAA.Backtracking;

/*
 * Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100

Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution
 */

import java.util.*;

public class NQueen {
    int N;
    int[][] ans;
    int[][] finalAns = null;
    // int maxxx = 0;

    /* A utility function to print solution */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    // Your utility functions goes here
    boolean solveNQ() {
        for (int i = 0; i < N; i++) {
            ans[0][i] = 1;
            helper(ans, 1);
            ans[0][i] = 0;
        }
        if (finalAns != null) {
            printSolution(finalAns);
            return true;
        } else {
            System.out.println("No Solution");
            return false;
        }
    }

    public void helper(int[][] mat, int row) {
        if (row == N) {
            if (finalAns == null) {
                finalAns = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        finalAns[i][j] = mat[i][j];
                    }
                }
            }

            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(mat, row, i)) {
                mat[row][i] = 1;
                helper(mat, row + 1);
                mat[row][i] = 0;
            }
        }
    }

    public boolean isSafe(int[][] mat, int row, int col) {
        for (int i = 0; i < N; i++) {
            if (mat[row][i] == 1 || mat[i][col] == 1)
                return false;
        }
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (mat[r][c] == 1)
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < N) {
            if (mat[r][c] == 1)
                return false;
            r--;
            c++;
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        NQueen Queen = new NQueen();
        Queen.N = sc.nextInt();
        Queen.ans = new int[Queen.N][Queen.N];
        for (int i = 0; i < Queen.N; i++) {
            for (int j = 0; j < Queen.N; j++) {
                Queen.ans[i][j] = 0;
            }
        }
        // Queen.maxxx = 0;
        Queen.solveNQ();
        sc.close();
    }
}