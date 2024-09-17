package Exercises.Graphs;
import java.util.*;

public class Find_Shortest_Path {
    static class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        //  Create the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        // Implementing Dijkstra's Algorithm
        // Given, source 1, destination n
        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0; // shortest path from source 1 to destination 1 is 0

        // parent array to track the shortest path
        int[] parent = new int[n+1];
        // initially the parent of node i is i
        for (int i=1; i<=n; i++) parent[i] = i;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        // source 1 to destination 1 weight is 0
        minHeap.add(new Pair(1,0));

        while (!minHeap.isEmpty()) {
            Pair parentNode = minHeap.poll();
            int node = parentNode.node;
            int dist = parentNode.weight;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int newDist = dist + neighbor.weight;

                if (newDist < answer[adjNode]) {
                    // have found the shortest path so far to reach the adjacent node
                    answer[adjNode] = newDist;
                    minHeap.add(new Pair(adjNode, newDist));
                    // Mark from where it has come to the adjNode
                    parent[adjNode] = node;
                }
            }
        }
        int destNode = n;
        List<Integer> path = new ArrayList<>();
        // No path from source to destination
        if (answer[destNode] == Integer.MAX_VALUE) return path;

        // Checking back in reverse order to know from where it came to the destination node
        while (parent[destNode] != destNode) {
            path.add(destNode);
            destNode = parent[destNode];
        }
        path.add(1); // source node
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        System.out.println(shortestPath(5,6,new int[][]{{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}}));
    }
}
