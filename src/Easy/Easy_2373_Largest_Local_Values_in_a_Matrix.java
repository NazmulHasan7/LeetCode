// 2373. Largest Local Values in a Matrix
package Easy;
import java.util.Arrays;

public class Easy_2373_Largest_Local_Values_in_a_Matrix {
    public static int getMax(int[][] grid, int r, int c) {
        int max = Integer.MIN_VALUE;
        for (int i=r; i<r+3; i++)
            for (int j=c; j<c+3; j++)
                if (grid[i][j] > max)
                    max = grid[i][j];
        return max;
    }
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] largest = new int[n-2][n-2];
        for (int i=0; i<n-2; i++) {
            for (int j=0; j<n-2; j++) {
                largest[i][j] = getMax(grid, i, j);
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int[][] largest = largestLocal(
                new int[][] {{9,9,8,1}, {5,6,2,6},{8,2,6,4},{6,2,2,2}}
        );
        for (int[] a : largest)
            System.out.println(Arrays.toString(a));
    }
}
