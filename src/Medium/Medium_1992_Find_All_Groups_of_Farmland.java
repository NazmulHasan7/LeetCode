// 1992. Find All Groups of Farmland
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1992_Find_All_Groups_of_Farmland {
    private static void dfs(int[][] grid, int r1, int c1, int[] r2c2) {
        if (r1 < 0 || c1 < 0 || r1 >= grid.length || c1 >= grid[0].length || grid[r1][c1] == 0)
            return;
        grid[r1][c1] = 0; // mark as visited
        r2c2[0] = Math.max(r1, r2c2[0]);
        r2c2[1] = Math.max(c1, r2c2[1]);

        dfs(grid, r1-1, c1, r2c2);
        dfs(grid, r1+1, c1, r2c2);
        dfs(grid, r1, c1-1, r2c2);
        dfs(grid, r1, c1+1, r2c2);
    }
    public static int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        List<int[]> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (land[i][j] == 1) {
                    int[] r2c2 = new int[2];
                    dfs(land, i, j, r2c2);
                    answer.add(new int[]{i,j,r2c2[0], r2c2[1]});
                }
            }
        }
        int[][] result = new int[answer.size()][4];
        for (int i=0; i<result.length; i++)
            result[i] = answer.get(i);
        return result;
    }
    public static int[][] findFarmlandBruteForce(int[][] land) {
        int n = land.length, m = land[0].length;
        List<int[]> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int r1 = i, c1 = j, r2 = i, c2 = j;
                    // Find bottom-right indices
                    while (r2 + 1 < n && land[r2 + 1][c1] == 1)
                        r2++;
                    while (c2 + 1 < m && land[r1][c2 + 1] == 1)
                        c2++;
                    // Mark all the nodes within the range visited
                    for (int r = r1; r <= r2; r++)
                        for (int c = c1; c <= c2; c++)
                            land[r][c] = 0;

                    answer.add(new int[]{r1, c1, r2, c2});
                }
            }
        } return answer.toArray(new int[answer.size()][4]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1},{1,1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{0}})));
        System.out.println(Arrays.deepToString(findFarmlandBruteForce(new int[][]{{1,0,0},{0,1,1},{0,1,1}})));
        System.out.println(Arrays.deepToString(findFarmlandBruteForce(new int[][]{{1,1},{1,1}})));
        System.out.println(Arrays.deepToString(findFarmlandBruteForce(new int[][]{{0}})));
    }
}
