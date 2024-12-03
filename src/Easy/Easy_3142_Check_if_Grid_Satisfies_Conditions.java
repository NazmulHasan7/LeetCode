// 3142. Check if Grid Satisfies Conditions
package Easy;

public class Easy_3142_Check_if_Grid_Satisfies_Conditions {
    public static boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (r < m-1 && grid[r][c] != grid[r+1][c]) return false;
                else if (c < n-1 && grid[r][c] == grid[r][c+1]) return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(satisfiesConditions(new int[][]{{1,0,2},{1,0,2}}));
        System.out.println(satisfiesConditions(new int[][]{{1,1,1},{0,0,0}}));
        System.out.println(satisfiesConditions(new int[][]{{1},{2},{3}}));
    }
}
