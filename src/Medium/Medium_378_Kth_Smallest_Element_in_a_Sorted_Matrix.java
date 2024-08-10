// 378. Kth Smallest Element in a Sorted Matrix
package Medium;
import java.util.PriorityQueue;

public class Medium_378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] row : matrix)
            for (int num : row) minHeap.add(num);

        while (k-- > 1) minHeap.poll();
        if (!minHeap.isEmpty())
            return minHeap.poll();
        return Integer.MIN_VALUE;
    }
    public int kthSmallestBetter(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Binary Search Approach
        int left = mat[0][0];
        int right = mat[n-1][m-1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(mat, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        } return left;
    }
    public int countLessEqual(int[][] mat,int x){
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < m) {
            if (mat[row][col] <= x) {
                // All elements in the current row up to col are less than or equal to x
                count += row + 1;
                col++;
            } else {
                // Move up in the same column
                row--;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{
                {1,5,9},{10,11,13},{12,13,15}}, 8));
        System.out.println(kthSmallest(new int[][]{{-5}}, 1));
    }
}
