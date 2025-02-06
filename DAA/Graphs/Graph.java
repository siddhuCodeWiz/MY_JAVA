package DAA.Graphs;
import java.util.*;
// You are given an undirected graph represented by vertices and edges. 
// Your task is to implement Breadth-First Search (BFS) traversal from a given starting vertex. 
// The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex.

// Input Format:
// --------------
// Line-1: An integer V, the number of vertices.
// Line-2: An integer E, the number of edges.
// Line-3 to E: The next E lines contain two integers source and destination, representing an edge between the two vertices in the graph.
// Line-E+1: The starting vertex S from which BFS traversal should begin.

// Output Format:
// ---------------
// Line-1: Print the vertices visited in BFS order starting from the given vertex S.

// Constraints:
// ------------
// *1 ≤ V ≤ 100
// *0 ≤ E ≤ V * (V - 1)
// *0 ≤ source, destination, S < V

// Sample Input-1:
// ---------------
// 5
// 8
// 0 1
// 0 4
// 1 0
// 1 2
// 1 3
// 1 4
// 2 3
// 3 4
// 0

// Sample Output-1:
// -----------------
// 0 1 4 2 3 

// Sample Input-1:
// ---------------
// 4
// 4
// 0 1
// 0 2
// 1 3
// 2 3
// 2

// Sample Output-2:
// ----------------
// 2 0 3 1 




public class Graph {
    ArrayList<ArrayList<Integer>> adjList;
    int s;

    Graph(int s) {
        this.s = s;
        adjList = new ArrayList<>(s);
        for(int i = 0; i < s; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int ed) {
        adjList.get(v).add(ed);
        adjList.get(ed).add(v);
    }

    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Boolean> visited = new ArrayList<>(s);
        
        for(int i = 0; i < s; i++) {
            visited.add(false);
        }

        if(start < s) {
            q.add(start);
            visited.set(start, true);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            
            for(int i : adjList.get(curr)) {
                if(!visited.get(i)) {
                    q.add(i);
                    visited.set(i, true);
                }
            }
        }
    }

    public void dfs(int start){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[s];

        st.add(start); 
        visited[start] = true;

        while(!st.empty()){
            int curr = st.peek();
            System.out.print(curr+" ");
            st.pop();
            for(int i : adjList.get(curr)){
                if(visited[i]==false){
                    st.push(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Graph g = new Graph(n);
        int cons = sc.nextInt();
        for(int i=0; i<cons; i++){
            g.addEdge(sc.nextInt(), sc.nextInt());
        }
        int start = sc.nextInt();
        // g.bfs(start);
        g.dfs(start);
        sc.close();
    }
}


