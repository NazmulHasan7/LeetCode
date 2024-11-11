// 741. Cherry Pickup
package Hard;

public class Hard_741_Cherry_Pickup {
    // Going down and getting back at the (0,0) is the same as
    // Staring at (0,0) and going to (n-1,n-1) using two paths
    private static int n;
    private static Integer[][][][] dp;
    public static int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new Integer[n][n][n][n];
        int answer = solve(grid, 0, 0, 0, 0);
        return Math.max(answer, 0);
    }
    private static int solve(int[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE; // invalid case or the cell contains a block

        if (r1 == n-1 && c1 == n-1 && r2 == n-1 && c2 == n-1)
            return grid[r1][c1]; // both reached the destination

        if (dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];

        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) // if both are not in the same position
            cherries += grid[r2][c2];

        // explore all the four directions
        int dir1 = solve(grid, r1+1, c1, r2+1, c2); // down, down
        int dir2 = solve(grid, r1, c1+1, r2, c2+1); // right, right
        int dir3 = solve(grid, r1+1, c1, r2, c2+1); // down, right
        int dir4 = solve(grid, r1, c1+1, r2+1, c2); // right, down

        cherries += Math.max(dir1, Math.max(dir2, Math.max(dir3, dir4)));
        return dp[r1][c1][r2][c2] = cherries;
    }
    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
        System.out.println(cherryPickup(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}}));
    }
}
