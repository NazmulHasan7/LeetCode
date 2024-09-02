// 1254. Number of Closed Islands
package Medium;

public class Medium_1254_Number_of_Closed_Islands {
    private static boolean dfs(int r, int c, int n, int m, int[][] grid) {
        if (r<0 || c<0 || r>=n || c>=m) // out of bound
            return false; // island cannot be in the border
        if (grid[r][c] == 1) // this side has water
            return true; // closed in this side

        grid[r][c] = 1; // mark as visited
        // check for left, right, up and bottom
        boolean up = dfs(r-1, c, n, m, grid);
        boolean down = dfs(r+1, c, n, m, grid);
        boolean left = dfs(r, c-1, n, m, grid);
        boolean right = dfs(r, c+1, n, m, grid);
        return up && down && left && right;
    }
    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0 && dfs(i, j, n, m, grid))
                    count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{
                {1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}}));
        System.out.println(closedIsland(new int[][]{
                {0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}}));
        System.out.println(closedIsland(new int[][]{
                {1,1,1,1,1,1,1}, {1,0,0,0,0,0,1}, {1,0,1,1,1,0,1}, {1,0,1,0,1,0,1}, {1,0,1,1,1,0,1}, {1,0,0,0,0,0,1}, {1,1,1,1,1,1,1}}));
    }
}
