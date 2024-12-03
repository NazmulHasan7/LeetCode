// 57. Insert Interval
package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_57_Insert_Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> arr = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                // current interval end < new interval start
                arr.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                // found the spot
                break;
            } else { // overlap -> merge
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }

        arr.add(newInterval);
        while (i < n) { // Add rest of the intervals
            arr.add(intervals[i]);
            i++;
        }
        return arr.toArray(new int[arr.size()][]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }
}
