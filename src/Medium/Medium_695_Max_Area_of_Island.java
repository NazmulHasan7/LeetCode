// 695. Max Area of Island
package Medium;

public class Medium_695_Max_Area_of_Island {
    static int currentArea;
    private static void dfs(int r, int c, int n, int m, int[][] grid) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0)
            return;
        grid[r][c] = 0;
        currentArea++;

        dfs(r-1, c, n, m, grid);
        dfs(r+1, c, n, m, grid);
        dfs(r, c-1, n, m, grid);
        dfs(r, c+1, n, m, grid);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                currentArea = 0;
                dfs(i, j, n, m, grid);
                maxArea = Math.max(maxArea, currentArea);
            }
        } return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
        System.out.println(maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
    }
}
