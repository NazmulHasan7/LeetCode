// 3619. Count Islands With Total Value Divisible by K
package Medium;

public class Medium_3619_Count_Islands_With_Total_Value_Divisible_by_K {
    // O(m * n) -> all the cells are visited only once
    public static int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                if (grid[r][c] != 0)
                    if (dfs(grid, r, c, rows, cols) % k == 0)
                        count++;
        return count;
    }
    private static int dfs(int[][] grid, int r, int c, int rn, int cn) {
        int sum = 0;
        if (r < 0 || c < 0 || r >= rn || c >= cn || grid[r][c] == 0)
            return 0;

        sum += grid[r][c];
        grid[r][c] = 0; // mark grid as visited

        sum += dfs(grid, r+1, c, rn, cn);
        sum += dfs(grid, r, c+1, rn, cn);
        sum += dfs(grid, r-1, c, rn, cn);
        sum += dfs(grid, r, c-1, rn, cn);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(countIslands(new int[][]{{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}}, 5));
        System.out.println(countIslands(new int[][]{{3,0,3,0}, {0,3,0,3}, {3,0,3,0}}, 3));
    }
}
