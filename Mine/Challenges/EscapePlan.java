package Mine.Challenges;

import java.util.*;

/*Brahmi and his gang have been chased by a group of police officers and are now
trapped in a building with M×N rooms, arranged in a grid format. Each room is
connected to its adjacent rooms both horizontally and vertically, forming a
complex layout. Fortunately, some rooms in the building are designated as
"safe zones," providing a possible escape for Brahmi and his gang.

The building's rooms are marked with the following values:
-1 : Danger Zone - an area that Brahmi and his gang cannot enter.
0 : Safe Zone - an area that provides a possible escape.
-2 : Occupied by a gang member.

Your task is to help Brahmi and his gang reach the nearest safe zones by
calculating the minimum distance from each gang member's room to a safe zone,
avoiding danger zones. If a gang member is unable to reach any safe zone,
mark their room with -2.

## Input Format:

Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

## Output Format:

Print an integer as result.

## Sample Input-1:

4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

## Sample Output-1:

3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4 */

public class EscapePlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();


        // int arr[][] = {{-2, -1, 0, -2},
        //     {-2, -2, -2, -1},
        //     {-2, -1, -2, -1},
        //     {0, -1, -2, -2}};

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        arr = escapeRoute(m, n, arr);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[][] startDFS(int m, int n, int[][] arr, int k, int l){

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = false;
            }
        }
        queue.add(new int[]{k, l});
        visited[k][l] = true;

        int nx, ny;

        while(!queue.isEmpty()){
            int[] currInd = queue.poll();

            for(int[] dir : dirs){
                nx = dir[0]+currInd[0];
                ny = dir[1]+currInd[1];

                if(nx>=0 && nx<m && ny>=0 && ny<n &&visited[nx][ny]==false && arr[nx][ny]!=-1 && arr[nx][ny]!=0){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if(arr[nx][ny]<0){
                        arr[nx][ny]=(arr[currInd[0]][currInd[1]])+1;
                    } else{
                        if(arr[nx][ny] > (arr[currInd[0]][currInd[1]])+1){
                            arr[nx][ny]=(arr[currInd[0]][currInd[1]])+1;
                        }
                    }
                }
            }


        }

        return arr;
    }

    public static int[][] escapeRoute(int m, int n, int[][] arr){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0){
                    arr = startDFS(m, n, arr, i, j);
                }
            }
        }

        return arr;
    }
}
