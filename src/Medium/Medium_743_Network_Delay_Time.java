// 743. Network Delay Time
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_743_Network_Delay_Time {
    static class Pair {
        int node;
        int weight;
        Pair (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        // Create Graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        // Using Dijkstra's Algorithm
        int[] minDistances = new int[n + 1];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[k] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.add(new Pair(k, 0));

        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int node = current.node;
            int dist = current.weight;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int newDist = dist + neighbor.weight;
                if (newDist < minDistances[adjNode]) {
                    minDistances[adjNode] = newDist;
                    minHeap.add(new Pair(adjNode, newDist));
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++)
            answer = Math.max(answer, minDistances[i]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
        System.out.println(networkDelayTime(new int[][]{{1,2,1}},2,1));
        System.out.println(networkDelayTime(new int[][]{{1,2,1}},2,2));
    }
}
