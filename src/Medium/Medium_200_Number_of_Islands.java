// 200. Number of Islands
package Medium;

public class Medium_200_Number_of_Islands {
    private static void dfs(int r, int c, int n, int m, char[][] grid) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        dfs(r+1, c, n, m, grid);
        dfs(r-1, c, n, m, grid);
        dfs(r, c+1, n, m, grid);
        dfs(r, c-1, n, m, grid);
    }
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, n, m, grid);
                }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
        System.out.println(numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }
}
