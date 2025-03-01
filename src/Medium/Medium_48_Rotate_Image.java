// 48. Rotate Image
package Medium;
import java.util.Arrays;

public class Medium_48_Rotate_Image {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // First transpose the matrix
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Now reverse the matrix column wise
        for (int i=0; i<n; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
