// 2658. Maximum Number of Fish in a Grid
package Medium;

public class Medium_2658_Maximum_Number_of_Fish_in_a_Grid {
    public static int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int answer = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if (grid[i][j] > 0)
                    answer = Math.max(answer, dfs(i, j, n, m, grid));
        return answer;
    }
    private static int dfs(int r, int c, int n, int m, int[][] grid) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0)
            return 0;

        int fishes = grid[r][c];
        grid[r][c] = 0;
        return fishes + dfs(r-1,c,n,m,grid) + dfs(r+1,c,n,m,grid)
                + dfs(r,c-1,n,m,grid) + dfs(r,c+1,n,m,grid);
    }
    public static void main(String[] args) {
        System.out.println(findMaxFish(new int[][]{
                {0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}}));
        System.out.println(findMaxFish(new int[][]{
                {1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}}));
    }
}
