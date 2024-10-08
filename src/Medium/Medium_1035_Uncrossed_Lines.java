// 1035. Uncrossed Lines
package Medium;
import java.util.Arrays;

public class Medium_1035_Uncrossed_Lines {
    // Recursion + Memoization
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, nums1, nums2, 0, 0, n, m);
    }
    private static int solve(int[][] dp, int[] nums1, int[] nums2, int i, int j, int n, int m) {
        if (i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (nums1[i] == nums2[j])
            return dp[i][j] = 1 + solve(dp, nums1, nums2, i+1, j+1, n, m);

        return dp[i][j] = Math.max(
                solve(dp, nums1, nums2, i+1, j, n, m),
                solve(dp, nums1, nums2, i, j+1, n, m)
        );
    }
    // Tabulation
    public static int maxUncrossedLinesTabulation(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n+1][m+1];
        // dp[i][j] -> Max number of lines can be drawn with nums1[i] and nums2[j]

        // Maximum of number of lines can be drawn when nums1 is empty -> 0
        Arrays.fill(dp[0], 0);
        // Maximum of number of lines can be drawn when nums2 is empty -> 0
        for (int r=0; r<n; r++) dp[r][0] = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        } return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}
