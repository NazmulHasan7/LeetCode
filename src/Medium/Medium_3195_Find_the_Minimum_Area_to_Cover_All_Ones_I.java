// 3195. Find the Minimum Area to Cover All Ones I
package Medium;

public class Medium_3195_Find_the_Minimum_Area_to_Cover_All_Ones_I {
    public static int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = -1, maxY = -1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                }
            }
        } return (maxX - minX + 1) * (maxY - minY + 1);
    }
    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0,1,0},{1,0,1}}));
        System.out.println(minimumArea(new int[][]{{1,0},{0,0}}));
    }
}
