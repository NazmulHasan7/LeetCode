// 59. Spiral Matrix II
package Medium;
import java.util.Arrays;

public class Medium_59_Spiral_Matrix_II {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int size = n * n;
        int idx = 0;

        int startRow = 0, startCol = 0, endRow = n-1, endCol = n-1;
        while (idx < size) {
            for (int i = startCol; i <= endCol; i++)
                matrix[startRow][i] = ++idx;
            startRow++;

            for (int i = startRow; i <= endRow; i++)
                matrix[i][endCol] = ++idx;
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--)
                    matrix[endRow][i] = ++idx;
                endRow--;
            }
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--)
                    matrix[i][startCol] = ++idx;
                startCol++;
            }
        } return matrix;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }
}
