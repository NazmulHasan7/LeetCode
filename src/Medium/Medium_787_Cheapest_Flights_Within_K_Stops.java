// 787. Cheapest Flights Within K Stops
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_787_Cheapest_Flights_Within_K_Stops {
    public static int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new int[]{v, w});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        distance[src] = 0;

        int step = 0;
        while (!queue.isEmpty() && step <= k) {
            int N = queue.size();
            while (N-- > 0) {
                int[] top = queue.poll();
                int u = top[0];
                int dist = top[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int cost = neighbor[1];
                    if (dist + cost < distance[v]) {
                        distance[v] = dist + cost;
                        queue.add(new int[]{v, distance[v]});
                    }
                }
            } step++;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    public static void main(String[] args) {
        System.out.println(findCheapestPriceBFS(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1));
        System.out.println(findCheapestPriceBFS(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1));
        System.out.println(findCheapestPriceBFS(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,0));
    }
}
