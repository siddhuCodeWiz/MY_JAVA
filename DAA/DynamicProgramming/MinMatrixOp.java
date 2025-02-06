package DAA.DynamicProgramming;

import java.util.*;

public class MinMatrixOp {
    int N;
    int[][] arr;
    // 8 3 3 4 4 2 2 7 7 6
    public void calOps(){
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinMatrixOp mmo = new MinMatrixOp();
        mmo.N = sc.nextInt();
        mmo.arr = new int[mmo.N][2];
        for(int i=0; i<mmo.N; i++){
            mmo.arr[i][0] = sc.nextInt();
            mmo.arr[i][1] = sc.nextInt();
        }
    }
} 