// 417. Pacific Atlantic Water Flow
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_417_Pacific_Atlantic_Water_Flow {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> answer = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // reverse dfs from the cells connected to pacific and atlantic ocean
        for (int r=0; r<rows; r++) {
            // first column -> connected to pacific ocean
            dfs(heights, r, 0, pacific);
            // last column -> connected to atlantic ocean
            dfs(heights, r, cols-1, atlantic);
        }
        for (int c=0; c<cols; c++) {
            // first row -> connected to pacific ocean
            dfs(heights, 0, c, pacific);
            // last row -> connected to atlantic ocean
            dfs(heights, rows-1, c, atlantic);
        }

        // check which cells are connected
        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                if (pacific[r][c] && atlantic[r][c])
                    answer.add(List.of(r,c));

        return answer;
    }
    private static void dfs (int[][] height, int r, int c, boolean[][] ocean) {
        int currentHeight = height[r][c];
        ocean[r][c] = true; // mark the cell as connected to the ocean

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < height.length && newC >= 0 && newC < height[0].length) {
                if (!ocean[newR][newC] && height[newR][newC] >= currentHeight) {
                    // we are doing a reverse dfs so current height <= next height
                    dfs(height, newR, newC, ocean);
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
        System.out.println(pacificAtlantic(new int[][]{{1}}));
    }
}
