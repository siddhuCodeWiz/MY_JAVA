package DAA.DynamicProgramming;


import java.util.*;
public class MaxSubArray {
    int N;
    ArrayList<Integer> arr;
    int maxxx = Integer.MIN_VALUE;
    // 3 -6 4 -5 2 -3 4 -3
    // 4

    public void findMax(){
        int sum = 0;
        int i=0;
        while(i<N){
            if(sum+arr.get(i)<0){
                sum = 0;
            }
            else{
                sum+=arr.get(i);
                maxxx = Math.max(maxxx, sum);
            }
            i++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxSubArray ms = new MaxSubArray();
        ms.N = sc.nextInt();
        ms.arr = new ArrayList<>();
        for(int i=0; i<ms.N; i++){
            ms.arr.add(sc.nextInt());
        }
        ms.findMax();
        System.out.println(ms.maxxx);
        sc.close();
    }
}
