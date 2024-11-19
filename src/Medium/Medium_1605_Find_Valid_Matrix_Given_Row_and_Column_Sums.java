// 1605. Find Valid Matrix Given Row and Column Sums
package Medium;
import java.util.Arrays;

public class Medium_1605_Find_Valid_Matrix_Given_Row_and_Column_Sums {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] matrix = new int[m][n];
        int r = 0, c = 0;

        while (r < m && c < n) {
            // take the minimum of the row and col sum
            matrix[r][c] = Math.min(rowSum[r], colSum[c]);
            rowSum[r] -= matrix[r][c];
            colSum[c] -= matrix[r][c];

            if (rowSum[r] == 0) r++;
            if (colSum[c] == 0) c++;
        }
        return matrix;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(restoreMatrix(new int[]{3,8}, new int[]{4,7})));
        System.out.println(Arrays.deepToString(restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8})));
    }
}
