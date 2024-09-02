// 1020. Number of Enclaves
package Medium;

public class Medium_1020_Number_of_Enclaves {
    private static void dfs(int r, int c, int n, int m, int[][] grid) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0)
            return;

        grid[r][c] = 0;
        dfs(r-1, c, n, m, grid);
        dfs(r+1, c, n, m, grid);
        dfs(r, c-1, n, m, grid);
        dfs(r, c+1, n, m, grid);
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Return the number of land cells in grid for which
        // we cannot walk off the boundary of the grid in any number of moves.
        // dfs on first and last column
        for (int r=0; r<n; r++) {
            if (grid[r][0] == 1) dfs(r, 0, n, m, grid);
            if (grid[r][m-1] == 1) dfs(r, m-1, n, m, grid);
        }
        // dfs on first and last row
        for (int c=0; c<m; c++) {
            if (grid[0][c] == 1) dfs(0, c, n, m, grid);
            if (grid[n-1][c] == 1) dfs(n-1, c, n, m, grid);
        }
        int count = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if (grid[i][j] == 1) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{
                {0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(numEnclaves(new int[][]{
                {0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }
}
