// 1267. Count Servers that Communicate
package Medium;

public class Medium_1267_Count_Servers_that_Communicate {
    public static int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }
        int count = 0;
        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1))
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countServers(new int[][]{{1,0},{0,1}}));
        System.out.println(countServers(new int[][]{{1,0},{1,1}}));
        System.out.println(countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
    }
}
