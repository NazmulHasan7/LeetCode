// 1514. Path with Maximum Probability
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_1514_Path_with_Maximum_Probability {
    static class Pair {
        int node;
        double prob;
        Pair (int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, Double.MIN_VALUE);
        maxProb[start_node] = 1; // probability of starting at start node 100%

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        maxHeap.add(new Pair(start_node, 1)); // probability of starting at start node 100%

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int node = current.node;
            double probability = current.prob;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                double newProb = probability * neighbor.prob;
                if (newProb > maxProb[adjNode]) {
                    maxProb[adjNode] = newProb;
                    maxHeap.add(new Pair(adjNode, maxProb[adjNode]));
                }
            }
        } return maxProb[end_node] == Double.MIN_VALUE ? 0 : maxProb[end_node];
    }
    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}},
                new double[] {0.5,0.5,0.2}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}},
                new double[] {0.5,0.5,0.3}, 0, 2));
    }
}
