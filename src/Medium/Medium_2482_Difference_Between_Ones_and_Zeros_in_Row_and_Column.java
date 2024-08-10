// 2482. Difference Between Ones and Zeros in Row and Column
package Medium;
import java.util.Arrays;

public class Medium_2482_Difference_Between_Ones_and_Zeros_in_Row_and_Column {
    public static int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rowOnes = new int[r];
        int[] colOnes = new int[c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                grid[i][j] = rowOnes[i]+colOnes[j]-(r-rowOnes[i])-(c-colOnes[j]);
        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        onesMinusZeros(grid);
        for (int[] g : grid)
            System.out.println(Arrays.toString(g));
        int[][] grid1 = {{1,1,1},{1,1,1}};
        onesMinusZeros(grid1);
        for (int[] g : grid1)
            System.out.println(Arrays.toString(g));
    }
}
