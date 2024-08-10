// 766. Toeplitz Matrix
package Easy;

public class Easy_766_Toeplitz_Matrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i=1; i<n; i++)
            for (int j=1; j<m; j++)
                if (matrix[i][j] != matrix[i-1][j-1])
                    return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]
                {{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(isToeplitzMatrix(new int[][]
                {{1,2}, {2,2}}));
    }
}
