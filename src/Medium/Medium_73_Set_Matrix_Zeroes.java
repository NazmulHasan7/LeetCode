// 73. Set Matrix Zeroes
package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_73_Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int r : rows)
            Arrays.fill(matrix[r], 0);

        for (int c : cols) {
            for (int i=0; i<m; i++)
                matrix[i][c] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
