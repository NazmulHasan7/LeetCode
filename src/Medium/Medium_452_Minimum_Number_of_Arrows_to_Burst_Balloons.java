// 452. Minimum Number of Arrows to Burst Balloons
package Medium;
import java.util.Arrays;

public class Medium_452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        // sort based on staring point
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int n = points.length;
        int[] prev = points[0];

        int arrowCount = 1;
        for (int i=1; i<n; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if (currStart > prev[1]) {
                // if current start > previous end -> a new arrow is required
                arrowCount++;
                prev = points[i];
            } else {
                // update the prev start and end points
                prev[0] = Math.max(prev[0], currStart);
                prev[1] = Math.min(prev[1], currEnd);
            }
        }
        return arrowCount;
    }
    public int findMinArrowShotsBetter(int[][] points) {
        int count = 1;
        // Sort based on the end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = points[0][1];
        for(int i = 1; i < points.length; i++) {
            // If current start position > previous end position -> A new arrow is required
            if(points[i][0] > prev) {
                count++;
                prev = points[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }
}
