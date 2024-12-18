// 498. Diagonal Traverse
package Medium;
import java.util.Arrays;

public class Medium_498_Diagonal_Traverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int n = rows * cols;
        int[] answer = new int[n];

        int idx = 0;
        boolean goingUp = true;
        int r = 0, c = 0; // initial position

        while (idx != n) {
            if (goingUp) { // up-right -> r-1, c+1
                while (r >= 0 && r < rows && c >= 0 && c < cols) {
                    answer[idx++] = mat[r][c];
                    r--;
                    c++;
                }
                if (c == cols) {
                    c--;
                    r+=2;
                } else {
                    r++;
                }
            } else { // down-left -> r+1, c-1
                while (r >= 0 && r < rows && c >= 0 && c < cols) {
                    answer[idx++] = mat[r][c];
                    r++;
                    c--;
                }
                if (r == rows) {
                    c+=2;
                    r--;
                } else {
                    c++;
                }
            }
            goingUp = !goingUp;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2},{3,4}})));
    }
}
