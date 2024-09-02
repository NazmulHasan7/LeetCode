// 1905. Count Sub Islands
package Medium;

public class Medium_1905_Count_Sub_Islands {
    private static boolean dfs(int r, int c, int n, int m, int[][] grid1, int[][] grid2) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid2[r][c] != 1)
            return true;

        boolean res = (grid1[r][c] == 1);
        grid2[r][c] = 0;
        res = res & dfs(r-1, c, n, m, grid1, grid2);
        res = res & dfs(r+1, c, n, m, grid1, grid2);
        res = res & dfs(r, c-1, n, m, grid1, grid2);
        res = res & dfs(r, c+1, n, m, grid1, grid2);
        return res;
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int count = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if (grid2[i][j] == 1 && grid1[i][j] == 1 && dfs(i, j, n, m, grid1, grid2))
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSubIslands(new int[][]{
                        {1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                new int[][] {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}
        ));
    }
}
