// 56. Merge Intervals
package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_56_Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(intervals[0]);

        for (int i=1; i<n; i++) {
            int[] temp = new int[2];
            if (arr.getLast()[1] >= intervals[i][0]) {
                temp[0] = Math.min(intervals[i][0], arr.getLast()[0]);
                temp[1] = Math.max(arr.getLast()[1], intervals[i][1]);
                arr.set(arr.size()-1, temp);
            } else {
                arr.add(intervals[i]);
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{4,5}})));
    }
}
