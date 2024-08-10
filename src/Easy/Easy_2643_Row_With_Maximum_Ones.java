// 2643. Row With Maximum Ones
package Easy;
import java.util.Arrays;

public class Easy_2643_Row_With_Maximum_Ones {
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int count = 0, max = 0, maxRow = 0;
        for (int i=0; i<mat.length; i++) {
            count = 0;
            for (int j=0; j<mat[i].length; j++) {
                count += mat[i][j];
            }
            if (count > max) {
                max = count;
                maxRow = i;
            }
        } return new int[] {maxRow, max};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowAndMaximumOnes(new int[][] {{0,1}, {1,0}})));
        System.out.println(Arrays.toString(rowAndMaximumOnes(new int[][] {{0,0,0}, {0,1,1}})));
        System.out.println(Arrays.toString(rowAndMaximumOnes(new int[][] {{0,0}, {1,1}, {0,0}})));
    }
}
