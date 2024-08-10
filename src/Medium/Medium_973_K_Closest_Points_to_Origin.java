// 973. K Closest Points to Origin
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_973_K_Closest_Points_to_Origin {
    public static int[][] kClosest(int[][] points, int k) {
        if (k == points.length) return points;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (point1, point2) -> {
                    int x1 = point1[0], y1 = point1[1];
                    int x2 = point2[0], y2 = point2[1];
                    return (x2*x2 + y2*y2) - (x1*x1 + y1*y1);
                }
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] answer = new int[k][2];
        while (k-- > 0)
            answer[k] = maxHeap.poll();
        return answer;
    }
    public int[][] kClosestBetter(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
    public static void main(String[] args) {
        int[][] res = kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        for (int[] arr : res)
            System.out.println(Arrays.toString(arr));
    }
}
