// 1463. Cherry Pickup II
package Hard;
import java.util.Arrays;

public class Hard_1463_Cherry_Pickup_II {
    public static int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows+1][cols+1][cols+1];
        for (int[][] dr : dp)
            for (int[] d : dr)
                Arrays.fill(d, -1);

        return solve(dp, grid, 0, 0, cols-1, rows, cols);
    }
    private static int solve(int[][][] dp, int[][] grid, int r, int rob1c, int rob2c, int rn, int cn) {
        if (rob1c < 0 || rob1c >= cn || rob2c < 0 || rob2c >= cn)
            return 0; // out of bound

        if (r == rn) return 0; // already reached the destination

        if (dp[r][rob1c][rob2c] != -1) return dp[r][rob1c][rob2c];

        int cherryCount = 0;
        cherryCount += grid[r][rob1c];
        cherryCount += grid[r][rob2c];

        int maxi = 0;
        // With each robot has 3 possible ways, makes a total of 9 combinations
        for (int i=rob1c-1; i<=rob1c+1; i++) {
            for (int j=rob2c-1; j<=rob2c+1; j++) {
                if (i < j) // Makes sure both robot do not pick cherry from the same position
                    maxi = Math.max(maxi, solve(dp, grid, r+1, i, j, rn, cn));
            }
        }
        return dp[r][rob1c][rob2c] = cherryCount + maxi;
    }
    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}}));
        System.out.println(cherryPickup(new int[][]{{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},
                {2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}}));
    }
}
