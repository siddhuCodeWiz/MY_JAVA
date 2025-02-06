package Lab;
import java.util.*;

public class _3a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rowBegin = 0, colBegin = 0, rowEnd = n-1, colEnd = n-1;
        // int c = 1;
        int[][] m = new int[n][n];
        // ArrayList<ArrayList<Integer>> mm = new ArrayList<>();
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            for(int i = colBegin; i<=colEnd; i++){
                m[rowBegin][i] = sc.nextInt();
                // c++;
            }
            rowBegin++;

            for(int i=rowBegin; i<=rowEnd; i++){
                m[i][colEnd]=sc.nextInt();
                // c++;
            }
            colEnd--;

            for(int i=colEnd; i>=colBegin; i--){
                m[rowEnd][i]=sc.nextInt();
                // c++;
            }
            rowEnd--;

            for(int i = rowEnd; i>=rowBegin; i--){
                m[i][colBegin] = sc.nextInt();
                // c++;
            }
            colBegin++;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
