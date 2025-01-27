// 2661. First Completely Painted Row or Column
package Medium;

public class Medium_2661_First_Completely_Painted_Row_or_Column {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // To store the value -> position map
        int[][] lookup = new int[m*n+1][2];

        for (int r=0; r<m; r++)
            for (int c=0; c<n; c++)
                lookup[mat[r][c]] = new int[]{r, c};

        // Stores the count of colored cell
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        int len = arr.length;
        for (int i=0; i<len; i++) {
            int[] pos = lookup[arr[i]];
            rowCount[pos[0]]++;
            colCount[pos[1]]++;
            if (rowCount[pos[0]] == n || colCount[pos[1]] == m)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstCompleteIndex(new int[]{1,3,4,2}, new int[][]{{1,4},{2,3}}));
        System.out.println(firstCompleteIndex(new int[]{2,8,7,4,1,3,5,6,9}, new int[][]{{3,2,5},{1,4,6},{8,7,9}}));
    }
}
