// 120. Triangle
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_120_Triangle {
    // Time Complexity: (O(n^2))
    // Space Complexity: (O(n^2))
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d,-1);
        return solve(dp, triangle, 0, 0, n);
    }
    private static int solve(int[][] dp, List<List<Integer>> triangle, int row, int col, int n) {
        if (row >= triangle.size()) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = triangle.get(row).get(col) +
                Math.min(solve(dp, triangle, row+1, col, n), solve(dp, triangle, row+1, col+1, n));
    }
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(2)));
        arr.add(new ArrayList<>(List.of(3,4)));
        arr.add(new ArrayList<>(List.of(6,5,7)));
        arr.add(new ArrayList<>(List.of(4,1,8,3)));
        System.out.println(minimumTotal(arr));
    }
}
