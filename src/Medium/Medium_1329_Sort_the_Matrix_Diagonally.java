// 1329. Sort the Matrix Diagonally
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Medium_1329_Sort_the_Matrix_Diagonally {
    // TC -> O(M∗N∗Log(Min(M,N))) SC -> O(M∗N)
    public static int[][] diagonalSort(int[][] mat) {
        // min heap -> keep each diagonal sorted
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // for the same diagonal the difference between #r and #c is same
                int key = j - i; // -ve diff for diagonals below the main diagonal
                // 0 for main diagonal and +ve diff for diagonals above the main diagonal
                map.computeIfAbsent(key, k -> new PriorityQueue<>()).add(mat[i][j]);
            }
        }
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                mat[i][j] = map.get(j-i).poll();

        return mat;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{
                {3,3,1,1},{2,2,1,2},{1,1,1,2}})));
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{
                {11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}})));
    }
}
