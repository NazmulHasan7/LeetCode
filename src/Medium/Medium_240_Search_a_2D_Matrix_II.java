// 240. Search a 2D Matrix II
package Medium;

public class Medium_240_Search_a_2D_Matrix_II {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Since each row is sorted, start at top right
        int r = 0, c = matrix[0].length-1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) return true;
                // If target > ideally the right most value of the row
                // Shrink the matrix row wise as all the values in the row < target
            else if (target > matrix[r][c]) r++;
                // Shrink the matrix column wise as all the values in that column after > target
            else c--;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(searchMatrix(new int[][]{
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
    }
}
