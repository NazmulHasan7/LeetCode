// 2022. Convert 1D Array Into 2D Array
package Easy;
import java.util.Arrays;

public class Easy_2022_Convert_1D_Array_Into_2D_Array {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[][] {};

        int[][] arr2D = new int[m][n];
        int x=0, y=0;
        for (int num : original) {
            arr2D[x][y++] = num;
            if (y == n) {
                y = 0;
                x++;
            }
        } return arr2D;
    }
    public static int[][] construct2DArrayBetter(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[][] {};

        int[][] arr2D = new int[m][n];
        int index = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                arr2D[i][j] = original[index++];
        return arr2D;
    }
    public static void main(String[] args) {
        int[][] res = construct2DArray(new int[] {1,2,3,4}, 2, 2);
        for (int[] arr : res)
            System.out.println(Arrays.toString(arr));
        res = construct2DArray(new int[] {1,2,3}, 1, 3);
        for (int[] arr : res)
            System.out.println(Arrays.toString(arr));
        res = construct2DArray(new int[] {1,2}, 1, 1);
        for (int[] arr : res)
            System.out.println(Arrays.toString(arr));
    }
}
