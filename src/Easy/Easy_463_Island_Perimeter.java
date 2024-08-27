// 463. Island Perimeter
package Easy;

public class Easy_463_Island_Perimeter {
    public static int islandPerimeter(int[][] grid) {
        int total = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == 1) {
                    total += 4;
                    // if land on the lower grid
                    if (r+1<rows && grid[r+1][c] == 1)
                        total--;
                    // if land on the upper grid
                    if (r-1>=0 && grid[r-1][c] == 1)
                        total--;
                    // if land on the left grid
                    if (c-1>=0 && grid[r][c-1] == 1)
                        total--;
                    // if land on the right grid
                    if (c+1<cols && grid[r][c+1] == 1)
                        total--;
                }
            }
        } return total;
    }
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}
        }));
        System.out.println(islandPerimeter(new int[][]{{1}}));
        System.out.println(islandPerimeter(new int[][]{{1,0}}));
    }
}
