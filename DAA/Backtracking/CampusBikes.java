package DAA.Backtracking;

/*
 * Mr. Revanth Reddy, Chief Minister of Telangana Government has passed a new G.O to Telangana police for safety of Telangana people. 
In this regard he announced new Vehicles to be released for all the stations working for this mission especially.
Here we have a 2D mesh, there are P police officers and V vehicles, with P<=V.
Each police officer and vehicle is a 2D coordinate on this mesh.
Here the government has assigned a unique vehicle to each police officer.

Now create a method which prints the minimum possible sum of distances between each police officer and their assigned vehicle.

Here the distance is between police officer Pi and vehicle Vi assigned to him.
And distance between Pi, Vi is calculated as follows: |Pi.x - Vi.x| + |Pi.y - Vi.y|


Input Format:
-------------
Line-1: Two integers P and V, number of police officers and vehicles.
Next P lines: Two space separated integers co-ordinates of Police officers.
Next V lines: Two space separated integers co-ordinates of Vehicles.

Output Format:
--------------
Print an integer, the minimum possible sum of distances.


Sample Input-1:
---------------
3 3
0 1		// co-ordinates of police
1 2
1 3
4 5		// co-ordinates of vehicles
2 5
3 6

Sample Output-1:
----------------
17


Sample Input-2:
---------------
2 2
0 0
2 1
1 2
3 3

Sample Output-2:
----------------
6

 */
import java.util.*;
public class CampusBikes {
    int p;
    int v;
    int minDis = Integer.MAX_VALUE;

    public void findMinDis(int[][] pc, int[][] vc){
        boolean[] visited = new boolean[v];
        helper(pc, vc, visited, 0, 0);
        
    }

    public void helper(int[][] pc, int[][] vc, boolean[] visited, int officerInd, int currDis){
        if(officerInd==p){
            minDis = Math.min(minDis, currDis);
            return;
        }

        for(int i=0; i<v; i++){
            if(!visited[i]){
                int dis = Math.abs(pc[officerInd][0]-vc[i][0])+Math.abs(pc[officerInd][1]-vc[i][1]);
                visited[i] = true;
                helper(pc, vc, visited, officerInd+1, currDis+dis);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CampusBikes campusBikes = new CampusBikes();
        campusBikes.p = sc.nextInt();
        campusBikes.v = sc.nextInt();

        int[][] pc = new int[campusBikes.p][2];
        int[][] vc = new int[campusBikes.v][2];

        for(int i=0; i<campusBikes.p; i++){
            pc[i][0] = sc.nextInt();
            pc[i][1] = sc.nextInt();
        }

        for(int i=0; i<campusBikes.v; i++){
            vc[i][0] = sc.nextInt();
            vc[i][1] = sc.nextInt();
        }

        campusBikes.findMinDis(pc, vc);
        System.out.println(campusBikes.minDis);

        sc.close();
    }
}
