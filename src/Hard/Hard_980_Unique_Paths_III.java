// 980. Unique Paths III
package Hard;

public class Hard_980_Unique_Paths_III {
    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int startX = -1, startY = -1, steps = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    steps++;
                }
            }
        } return solve(grid, startX, startY, steps);
    }
    private static int solve(int[][] grid, int x, int y, int steps) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1)
            return 0;

        if (grid[x][y] == 2) // destination reached
            return steps < 0 ? 1 : 0;

        grid[x][y] = -1; // marked the cell as visited in current traversal

        int count = solve(grid,x-1, y, steps-1)
                + solve(grid,x+1, y, steps-1)
                + solve(grid, x,y-1, steps-1)
                + solve(grid, x,y+1, steps-1);

        grid[x][y] = 0; // mark as unvisited
        return count;
    }
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
        System.out.println(uniquePathsIII(new int[][]{{0,1},{2,0}}));
    }
}
