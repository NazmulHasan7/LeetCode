// 1288. Remove Covered Intervals
package Medium;
import java.util.Arrays;

public class Medium_1288_Remove_Covered_Intervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return 1;

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // System.out.println(Arrays.deepToString(intervals));
        int prev = 0, count = 0;

        for (int i=1; i<n; i++) {
            if (intervals[i][0] >= intervals[prev][0] && intervals[i][1] <= intervals[prev][1])
                count++;
            else prev = i;
        }
        return n - count;
    }
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}}));
    }
}
