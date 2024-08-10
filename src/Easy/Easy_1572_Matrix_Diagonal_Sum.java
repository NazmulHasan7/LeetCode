// 1572. Matrix Diagonal Sum
package Easy;

public class Easy_1572_Matrix_Diagonal_Sum {
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i=0, j=n-1; i<n; i++, j--) {
            sum += mat[i][i] + mat[i][j];
            if (i == j) sum -= mat[i][j];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(diagonalSum(
                new int[][] {{1,2,3},
                             {4,5,6},
                             {7,8,9}})
        );
    }
}
