// 435. Non-overlapping Intervals
package Medium;
import java.util.Arrays;

public class Medium_435_Non_overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // Sort the intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int count = 0;
        for (int curr = 1; curr < n; curr++) {
            if (intervals[curr][0] >= end) {
                // non-overlapping
                end = intervals[curr][1];
            } else { // overlapping interval
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }
}
