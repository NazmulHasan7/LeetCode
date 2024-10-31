// 2684. Maximum Number of Moves in a Grid
package Medium;
import java.util.Arrays;

public class Medium_2684_Maximum_Number_of_Moves_in_a_Grid {
    public static int maxMoves(int[][] grid) {
        int answer = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] d : dp) Arrays.fill(d, -1);

        for (int r = 0; r < rows; r++)
            answer = Math.max(answer, solve(dp, grid, -1, r, 0, rows, cols));

        return answer - 1;
    }
    private static int solve(int[][] dp, int[][] grid, int prev, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return 0;

        if (grid[r][c] <= prev) return 0;

        if (dp[r][c] != -1) return dp[r][c];

        int maxMoves = 0;
        int move1 = 1 + solve(dp, grid, grid[r][c], r - 1, c + 1, rows, cols); // Up-Right
        int move2 = 1 + solve(dp, grid, grid[r][c], r, c + 1, rows, cols);     // Right
        int move3 = 1 + solve(dp, grid, grid[r][c], r + 1, c + 1, rows, cols); // Down-Right
        maxMoves = Math.max(move1, Math.max(move2, move3));
        return dp[r][c] = maxMoves;
    }
    public static void main(String[] args) {
        System.out.println(maxMoves(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}}));
        System.out.println(maxMoves(new int[][]{{3,2,4},{2,1,9},{1,1,7}}));
    }
}
