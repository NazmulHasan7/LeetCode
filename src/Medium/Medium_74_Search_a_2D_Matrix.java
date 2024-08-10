// 74. Search a 2D Matrix
package Medium;

public class Medium_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int start = 0, end = ints.length - 1;
            while (start <= end) {
                int mid = (end+start) / 2;
                if (ints[mid] == target)
                    return true;
                else if (ints[mid] > target)
                    end = mid - 1;
                else start = mid + 1;
            }
        } return false;
    }
    public static boolean searchMatrixBetter(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bottom = rows-1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols-1]) {
                // System.out.println(Arrays.toString(matrix[mid]));
                int start = 0, end = cols-1;
                while (start <= end) {
                    int midPoint = (start + end) / 2;
                    if (matrix[mid][midPoint] == target)
                        return true;
                    else if (matrix[mid][midPoint] < target)
                        start = midPoint + 1;
                    else end = midPoint - 1;
                } return false;
            }
            else if (matrix[mid][cols-1] < target)
                top = mid + 1;
            else bottom = mid - 1;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(searchMatrixBetter(new int[][] {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrixBetter(new int[][] {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }
}
