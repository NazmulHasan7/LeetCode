// 2596. Check Knight Tour Configuration
package Medium;

public class Medium_2596_Check_Knight_Tour_Configuration {
    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        return solve(grid, 0, 0, n, 0);
    }
    private static boolean solve(int[][] grid, int r, int c, int n, int value) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != value)
            return false; // out of bound or current cell value != expected

        if (value == n * n - 1) return true; // reached the final value

        return solve(grid, r-1, c-2, n, value+1) ||
                solve(grid, r-2, c-1, n, value+1) ||
                solve(grid, r-2, c+1, n, value+1) ||
                solve(grid, r-1, c+2, n, value+1) ||
                solve(grid, r+1, c-2, n, value+1) ||
                solve(grid, r+2, c-1, n, value+1) ||
                solve(grid, r+2, c+1, n, value+1) ||
                solve(grid, r+1, c+2, n, value+1);
    }
    public static void main(String[] args) {
        System.out.println(checkValidGrid(new int[][]{
                {0,11,16,5,20}, {17,4,19,10,15}, {12,1,8,21,6},
                {3,18,23,14,9}, {24,13,2,7,22}}));
        System.out.println(checkValidGrid(new int[][]{
                {0,3,6}, {5,8,1}, {2,7,4} }));
    }
}
