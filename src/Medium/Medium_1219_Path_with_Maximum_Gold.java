// 1219. Path with Maximum Gold
package Medium;

public class Medium_1219_Path_with_Maximum_Gold {
    static int rows, cols;
    private static int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0)
            return 0;

        int current = grid[r][c];
        int localMax = current;
        grid[r][c] = 0; // Mark grid[r][c] as visited

        // Explore the grid int top, bottom, left, right
        int top = dfs(grid, r-1, c);
        int bottom = dfs(grid, r+1, c);
        int left = dfs(grid, r, c-1);
        int right = dfs(grid, r, c+1);
        localMax = current + Math.max(Math.max(top, bottom), Math.max(left, right));

        // Mark the current grid as not visited
        grid[r][c] = current;
        return localMax;
    }
    public static int getMaximumGold(int[][] grid) {
        int max = 0;
        rows = grid.length;
        cols = grid[0].length;

        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                if (grid[r][c] != 0)
                    max = Math.max(max, dfs(grid, r, c));
        return max;
    }
    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{{0,6,0}, {5,8,7}, {0,9,0}}));
        System.out.println(getMaximumGold(new int[][]{{1,0,7}, {2,0,6}, {3,4,5}, {0,3,0}, {9,0,20}}));
    }
}
