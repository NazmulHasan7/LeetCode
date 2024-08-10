// 1642. Furthest Building You Can Reach
package Medium;
import java.util.PriorityQueue;

public class Medium_1642_Furthest_Building_You_Can_Reach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Approach -> Initially use all the bricks and store the maximum bricks required to the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int n = heights.length-1;

        for (int i = 0; i < n; i++) {
            int diff = heights[i+1] - heights[i];
            if (diff > 0) {
                bricks -= diff;
                maxHeap.add(diff);

                if (bricks < 0) {
                    // Ladder is used, cannot go to next building
                    if (ladders == 0) return i;
                    ladders--;
                    if (!maxHeap.isEmpty()) bricks += maxHeap.poll();
                }
            }
        } return n;
    }
    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12},5,1));
        System.out.println(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19},10,2));
        System.out.println(furthestBuilding(new int[]{14,3,19,3},17,0));
    }
}
