// 554. Brick Wall
package Medium;
import java.util.HashMap;
import java.util.List;

public class Medium_554_Brick_Wall {
    // MLE using array
    // TC & SC -> O(nm)
    public static int leastBricks(List<List<Integer>> wall) {
        int totalBricks = wall.size();
        HashMap<Integer, Integer> edges = new HashMap<>();

        // count the total number of edges
        int lastEdge = 0;
        for (int brickSize : wall.getFirst())
            lastEdge += brickSize;

        // edges[i] = count of the number of bricks that have edge at index i
        // int[] edges = new int[lastEdge+1];
        for (List<Integer> layer : wall) {
            int edge = 0;
            for (int brick : layer) {
                edge += brick;
                // edges[edge]++;
                if (edge != lastEdge)
                    edges.put(edge, edges.getOrDefault(edge, 0)+1);
            }
        }
        // System.out.println(edges);
        int minBricksCrossed = Integer.MAX_VALUE;
        // for (int i=0; i<lastEdge; i++) {
        for (int count : edges.values()) {
            // minBricksCrossed = Math.min(minBricksCrossed, totalBricks - edges[i]);
            minBricksCrossed = Math.min(minBricksCrossed, totalBricks - count);
        }
        // return minBricksCrossed;
        return minBricksCrossed == Integer.MAX_VALUE ? totalBricks : minBricksCrossed;
    }
    public static void main(String[] args) {
        List<List<Integer>> wall = List.of(List.of(1,2,2,1), List.of(3,1,2),
                List.of(1,3,2), List.of(2,4), List.of(3,1,2), List.of(1,3,1,1));
        System.out.println(leastBricks(wall));
        wall = List.of(List.of(1), List.of(1), List.of(1));
        System.out.println(leastBricks(wall));
    }
}
