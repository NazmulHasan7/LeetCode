// 566. Reshape the Matrix
package Easy;
import java.util.Arrays;

public class Easy_566_Reshape_the_Matrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (r*c != rows*cols) return mat;

        int rc = 0, cc = 0;
        int[][] result = new int[r][c];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (cc == c) {
                    cc = 0;
                    rc++;
                } result[rc][cc++] = mat[i][j];
            }
        } return result;
    }
    public static void main(String[] args) {
        int[][] result = matrixReshape(new int[][] {{1,2},{3,4}}, 1, 4);
        for (int[] res : result)
            System.out.println(Arrays.toString(res));
    }
}
