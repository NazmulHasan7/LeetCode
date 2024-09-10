// 2326. Spiral Matrix IV
package Medium;
import java.util.Arrays;

public class Medium_2326_Spiral_Matrix_IV {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] mat : matrix) Arrays.fill(mat, -1);

        int startRow = 0, startCol = 0, endRow = m, endCol = n;
        while (head != null) {
            for (int i=startCol; i<endCol && head != null; i++) {
                matrix[startRow][i] = head.val;
                head = head.next;
            }
            startRow++;
            for (int i=startRow; i<endRow && head != null; i++) {
                matrix[i][endCol-1] = head.val;
                head = head.next;
            }
            endCol--;
            for (int i=endCol-1; i>=startCol && head != null; i--) {
                matrix[endRow-1][i] = head.val;
                head = head.next;
            }
            endRow--;
            for (int i=endRow-1; i>=startRow && head != null; i--) {
                matrix[i][startCol] = head.val;
                head = head.next;
            }
            startCol++;
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[] arr = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head = new ListNode(3);

        ListNode temp = head;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        System.out.println(Arrays.deepToString(spiralMatrix(3,5,head)));
    }
}
