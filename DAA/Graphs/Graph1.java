package DAA.Graphs;

import java.util.*;

class Graph1 {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        graph.dijkistra(0);
    }
}

class Graph {
    int vertices;
    ArrayList<ArrayList<Node>> arr;

    Graph(int v) {
        this.vertices = v;
        arr = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            arr.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        arr.get(src).add(new Node(dest, weight));
        arr.get(dest).add(new Node(src, weight));
    }

    public void dijkistra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;

            for (Node neighbour : arr.get(u)) {
                int v = neighbour.vertex;
                int w = neighbour.weight;

                if (distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        System.out.println("Shortest distances from node " + start + ":");
        int maxTime = 0;
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + " : " + distances[i]);
            if (distances[i] != Integer.MAX_VALUE) {
                maxTime = Math.max(maxTime, distances[i]);
            }
        }
        System.out.println("Minimum time required to broadcast the message: " + maxTime);
    }
}

class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}