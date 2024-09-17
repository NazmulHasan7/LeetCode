// Dijkstra's shortest path algorithms
// Undirected Weighted Graph
package Exercises.Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Dijkstra's Algorithms can work with directed and undirected graphs
// Cannot work with graphs with negative edges
public class Dijkstra_Algorithm {
    static class Pair {
        int node;
        int weight;
        Pair (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] answer = new int[V];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[S] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        minHeap.add(new Pair(S, 0));

        while (!minHeap.isEmpty()) { // <- O(v)
            Pair p = minHeap.poll(); // <- O(log(v))
            int dist = p.weight;
            int node = p.node;
            for (ArrayList<Integer> arr: adj.get(node)) { // <- O(E)
                int adjNode = arr.get(0);
                int weight = arr.get(1);
                if (dist + weight < answer[adjNode]) {
                    answer[adjNode] = dist + weight;
                    minHeap.add(new Pair(adjNode, dist + weight)); // O(log(v))
                }
            }
        } return answer; // Time Complexity => V*log(v) + E*log(v))
    }
}
