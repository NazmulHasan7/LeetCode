// 1252. Cells with Odd Values in a Matrix
package Easy;

public class Easy_1252_Cells_with_Odd_Values_in_a_Matrix {
    public static int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i=0; i<indices.length; i++) {
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        int count = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if ((row[i] + col[j]) % 2 == 1)
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(oddCells(2, 2, new int[][] {{1,1}, {0,0}}));
        System.out.println(oddCells(2, 3, new int[][] {{0,1}, {1,1}}));
    }
}
