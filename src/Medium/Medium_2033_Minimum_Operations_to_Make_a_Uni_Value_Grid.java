// 2033. Minimum Operations to Make a Uni-Value Grid
package Medium;
import java.util.Arrays;

public class Medium_2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {
    public static int minOperations(int[][] grid, int x) {
        int size = grid.length * grid[0].length;
        int[] arr = new int[size];
        int idx = 0;
        int rem = grid[0][0] % x;

        for (int[] r : grid) {
            for (int c : r) {
                if (c % x != rem) return -1;
                arr[idx++] = c;
            }
        }

        Arrays.sort(arr);
        int median = arr[size / 2];
        int ops = 0;

        for (int num : arr)
            ops += Math.abs(median - num) / x;

        return ops;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{2,4},{6,8}}, 2));
        System.out.println(minOperations(new int[][]{{1,5},{2,3}}, 1));
        System.out.println(minOperations(new int[][]{{1,2},{3,4}}, 2));
    }
}
