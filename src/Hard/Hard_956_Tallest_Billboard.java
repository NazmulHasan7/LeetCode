// 956. Tallest Billboard
package Hard;
import java.util.Arrays;

public class Hard_956_Tallest_Billboard {
    // MLE -> Memory Limit Exceeded
    public static int tallestBillboard(int[] rods) {
        int n = rods.length;

        int[][][] dp = new int[n][5000][5000];
        for (int[][] dr : dp)
            for (int[] d : dr)
                Arrays.fill(d, -1);
        return solve(dp, rods, 0, n, 0, 0);
    }
    private static int solve(int[][][] dp, int[] rods, int idx, int n, int support1, int support2) {
        if (idx == n) {
            if (support1 == support2)
                return support1; // the billboard can be installed
            return 0; // the billboard cannot be installed
        }

        if (dp[idx][support1][support2] != -1)
            return dp[idx][support1][support2];

        // We have two options -> add the steel to support1 or add it to support 2
        int skip = solve(dp, rods, idx+1, n, support1, support2);
        int add1 = solve(dp, rods, idx+1, n, support1 + rods[idx], support2);
        int add2 = solve(dp, rods, idx+1, n, support1, support2 + rods[idx]);

        return dp[idx][support1][support2] = Math.max(skip, Math.max(add1, add2));
    }


    // Space Optimized with 2 changing variables
    public static int tallestBillboardOpt(int[] rods) {
        int n = rods.length;

        int[][] dp = new int[n][10001];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solveOpt(dp, rods, 0, n, 0) / 2;
    }
    private static int solveOpt(int[][] dp, int[] rods, int idx, int n, int diff) {
        if (idx == n) {
            if (diff == 0)
                return 0; // since we are only tracking the diff
            return Integer.MIN_VALUE; // the billboard cannot be installed
        }

        if (dp[idx][diff + 5001] != -1)
            return dp[idx][diff + 5001]; // +5001 to avoid -ve diff

        // We have two options -> add the steel to support1 or add it to support 2
        int skip = solveOpt(dp, rods, idx+1, n, diff);
        // since we are only tracking the diff keep adding the rod to the support
        int add1 = rods[idx] + solveOpt(dp, rods, idx+1, n, rods[idx] + diff);
        int add2 = rods[idx] + solveOpt(dp, rods, idx+1, n, diff - rods[idx]);

        return dp[idx][diff + 5001] = Math.max(skip, Math.max(add1, add2));
    }
    public static void main(String[] args) {
        System.out.println(tallestBillboard(new int[]{1,2,3,6}));
        System.out.println(tallestBillboard(new int[]{1,2,3,4,5,6}));
        System.out.println(tallestBillboard(new int[]{1,2}));
    }
}
