// 2257. Count Unguarded Cells in the Grid
package Medium;

public class Medium_2257_Count_Unguarded_Cells_in_the_Grid {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark the cells with walls as 1
        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = 1;

        // Mark the cells with guards as 2
        for (int[] guard : guards)
            grid[guard[0]][guard[1]] = 2;

        // Traverse the grid and mark the cells that can be guarded
        // For each guard check the cells they can guard
        for (int[] guard : guards) {
            int row = guard[0], col = guard[1];

            // Go in four direction -> Down, up, left, right
            for (int r=row+1; r<m; r++) {
                if (grid[r][col] == 1 || grid[r][col] == 2)
                    // cannot go more down as there is a wall or another guard
                    break;
                grid[r][col] = 3; // mark the cell as guarded
            }
            for (int r=row-1; r>=0; r--) {
                if (grid[r][col] == 1 || grid[r][col] == 2)
                    // cannot go more down as there is a wall or another guard
                    break;
                grid[r][col] = 3; // mark the cell as guarded
            }
            for (int c=col-1; c>=0; c--) {
                if (grid[row][c] == 1 || grid[row][c] == 2)
                    // cannot go more down as there is a wall or another guard
                    break;
                grid[row][c] = 3; // mark the cell as guarded
            }
            for (int c=col+1; c<n; c++) {
                if (grid[row][c] == 1 || grid[row][c] == 2)
                    // cannot go more down as there is a wall or another guard
                    break;
                grid[row][c] = 3; // mark the cell as guarded
            }
        }
        // Now, count the unguarded cells
        int answer = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j] == 0)
                    answer++;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(countUnguarded(4,6,
                new int[][]{{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}}));
        System.out.println(countUnguarded(3,3,
                new int[][]{{1,1}}, new int[][]{{0,1},{1,0},{2,1},{1,2}}));
    }
}
