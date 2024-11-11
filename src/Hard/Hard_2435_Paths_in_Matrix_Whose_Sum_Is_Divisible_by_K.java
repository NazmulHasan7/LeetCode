// 2435. Paths in Matrix Whose Sum Is Divisible by K
package Hard;

public class Hard_2435_Paths_in_Matrix_Whose_Sum_Is_Divisible_by_K {
    private static final int MOD = (int) 1E9 + 7;
    private static Integer[][][] dp;
    public static int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m+1][n+1][k+1];
        return solve(grid, 0, 0, m, n, k, 0);
    }
    private static int solve(int[][] grid, int r, int c, int m, int n, int k, int sum) {
        if (r >= m || c >= n) return 0;

        if (r == m-1 && c == n-1)
            return ((sum + grid[r][c]) % k) == 0 ? 1 : 0;

        int sumIdx = sum % k;
        if (dp[r][c][sumIdx] != null) return dp[r][c][sumIdx];

        int goDown = solve(grid, r+1, c, m, n, k, (sum + grid[r][c]) % k) % MOD;
        int goRight = solve(grid, r, c+1, m, n, k,(sum + grid[r][c]) % k) % MOD;

        return dp[r][c][sumIdx] = (goDown + goRight) % MOD;
    }
    public static void main(String[] args) {
        System.out.println(numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}},3));
        System.out.println(numberOfPaths(new int[][]{{0,0}},5));
        System.out.println(numberOfPaths(new int[][]{{7,3,4,9},{2,3,6,2},{2,3,7,0}},1));
    }
}
