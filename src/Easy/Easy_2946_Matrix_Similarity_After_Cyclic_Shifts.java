// 2946. Matrix Similarity After Cyclic Shifts
package Easy;

public class Easy_2946_Matrix_Similarity_After_Cyclic_Shifts {
    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                // After k operations the element after k index should be same
                if (mat[i][j] != mat[i][(j+k) % n])
                    return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areSimilar(new int[][] {{1,2,1,2},{5,5,5,5},{6,3,6,3}}, 2));
        System.out.println(areSimilar(new int[][] {{2,2},{2,2}}, 3));
        System.out.println(areSimilar(new int[][] {{1,2}}, 1));
    }
}
