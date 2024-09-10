// // 54. Spiral Matrix
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_54_Spiral_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int size = m * n;
        System.out.println(size);
        List<Integer> answer = new ArrayList<>();

        int startRow = 0, startCol = 0, endRow = m , endCol = n;
        int idx = 0;
        while (idx < size) {
            for (int i=startCol; i<endCol && idx<size; i++) {
                answer.add(matrix[startRow][i]);
                idx++;
            } startRow++;

            for (int i=startRow; i<endRow && idx<size; i++) {
                answer.add(matrix[i][endCol-1]);
                idx++;
            } endCol--;

            for (int i=endCol-1; i>=startCol && idx<size; i--) {
                answer.add(matrix[endRow-1][i]);
                idx++;
            } endRow--;

            for (int i=endRow-1; i>=startRow && idx<size; i--) {
                answer.add(matrix[i][startCol]);
                idx++;
            } startCol++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
