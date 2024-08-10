// 2679. Sum in a Matrix
package Medium;
import java.util.Arrays;

public class Medium_2679_Sum_in_a_Matrix {
    public static int matrixSum(int[][] nums) {
        int score = 0, max;
        for (int[] arr : nums) Arrays.sort(arr);

        for (int c=0; c<nums[0].length; c++) {
            max = 0;
            for (int r=0; r<nums.length; r++)
                max = Math.max(max, nums[r][c]);
            score += max;
        } return score;
    }
    public static void main(String[] args) {
        System.out.println(matrixSum(new int[][] {{7,2,1},{6,4,2},{6,5,3},{3,2,1}}));
        System.out.println(matrixSum(new int[][] {{1}}));
    }
}
