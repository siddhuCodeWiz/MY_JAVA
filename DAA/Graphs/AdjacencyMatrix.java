package DAA.Graphs;


/*You are given V vertices representing a graph with V nodes. 
The graph is undirected, and your task is to represent this graph using an adjacency matrix.

Adjacency Matrix: An adjacency matrix is a 2D array of size V x V where:
	matrix[i][j] = 1 indicates that there is an edge between vertex i and vertex j.
	matrix[i][j] = 0 indicates that there is no direct edge between vertex i and vertex j.

Add Edge: Implement a function to add edges between two vertices i and j. 
Since the graph is undirected, an edge from i to j implies an edge from j to i.

Display Matrix: Implement a function to display the adjacency matrix.

Input Format:
-------------
Line-1: An integer V, the number of vertices.
Line-2: An integer E, the number of edges.
Next E lines: Two integers i and j for each line, representing an edge between vertices i and j.

Output Format:
---------------
Print the adjacency matrix of the graph after adding all edges.

Constraints:
------------
*1 <= V <= 20 (Maximum of 20 vertices)
*0 <= i, j < V (Valid vertex indices)
*0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

Sample Input-1:
---------------
4
4
0 1
0 2
1 2
2 3

Sample Output-1:
----------------
0 1 1 0 
1 0 1 0 
1 1 0 1 
0 0 1 0 

Sample Input-2:
---------------
5
5
0 1
0 4
1 3
1 2
3 4

Sample Output-2:
----------------
0 1 0 0 1 
1 0 1 1 0 
0 1 0 0 0 
0 1 0 0 1 
1 0 0 1 0 
 */
import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] adjMat = new int[n][n];

        int ed = sc.nextInt();
        for(int i=0; i<ed; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            adjMat[s][e]=1;
            adjMat[e][s]=1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}


// class Node{
//     int start;
//     int end;

// }