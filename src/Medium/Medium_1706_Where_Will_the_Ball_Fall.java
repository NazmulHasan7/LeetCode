// 1706. Where Will the Ball Fall
package Medium;
import java.util.Arrays;

public class Medium_1706_Where_Will_the_Ball_Fall {
    private static int dfs(int[][] grid, int r, int c, int m, int n) {
        if (r == m) return c; // reached the end

        if (grid[r][c] == 1) {
            if (c == n-1) // goes right -> out of the box
                return -1;
            else if (grid[r][c+1] == -1)
                return -1; // makes the v shape, ball is stuck
        } else {
            if (c == 0) // goes left -> out of the box
                return -1;
            else if (grid[r][c-1] == 1)
                return -1; // makes the v shape, ball is stuck
        }

        if (grid[r][c] == 1)
            return dfs(grid, r+1, c+1, m, n);
        else return dfs(grid, r+1, c-1, m, n);
    }
    public static int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] answer = new int[n];
        for (int c=0; c<n; c++)
            answer[c] = dfs(grid, 0, c, m, n);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBall(new int[][]{
                {1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}
        })));
        System.out.println(Arrays.toString(findBall(new int[][]{{-1}})));
        System.out.println(Arrays.toString(findBall(new int[][]{
                {1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}
        })));
    }
}
