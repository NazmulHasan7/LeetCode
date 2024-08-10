// 867. Transpose Matrix
package Easy;
import java.util.Arrays;

public class Easy_867_Transpose_Matrix {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int i=0; i<col; i++)
            for (int j=0; j<row; j++)
                result[i][j] = matrix[j][i];
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix1 = transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        for (int[] row : matrix1)
            System.out.println(Arrays.toString(row));

        int[][] matrix2 = transpose(new int[][] {{1,2,3},{4,5,6}});
        for (int[] row : matrix2)
            System.out.println(Arrays.toString(row));
    }
}
