// 3111. Minimum Rectangles to Cover Points
package Medium;
import java.util.Arrays;

public class Medium_3111_Minimum_Rectangles_to_Cover_Points {
    /* private static void quickSort2D(int[][] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort2D(arr, start, pIndex-1);
            quickSort2D(arr, pIndex+1, end);
        }
    }
    private static int partition(int[][] arr, int start, int end) {
        int[] pivot = arr[end];
        int pIndex = start;
        for (int i=start; i<end; i++) {
            if (compareRows(arr[i], pivot) < 0) {
                swap(arr, pIndex, i);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }
    private static int compareRows(int[] row, int[] pivot) {
        int n = row.length;
        for (int i=0; i<n; i++) {
            if (row[i] < pivot[i])
                return -1;
            if (row[i] > pivot[i])
                return 1;
        } return 0;
    }
    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } */
    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        int count = 0;
        int n = points.length;
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));

        for (int i=0; i<n; ) {
            int j = i;
            while (j < n && (points[j][0] - points[i][0]) <= w)
                j++;

            count++;
            i = j;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(minRectanglesToCoverPoints(new int[][]{{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}},1));
        System.out.println(minRectanglesToCoverPoints(new int[][]{{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}},2));
    }
}
