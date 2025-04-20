// 2070. Most Beautiful Item for Each Query
package Medium;
import java.util.Arrays;

public class Medium_2070_Most_Beautiful_Item_for_Each_Query {
    // O(m log m + n log n + (m + n))
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int m = items.length;
        // quickSort2D(items, 0, m-1);
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] queryWithIndex = new int[n][2];
        for (int i=0; i<n; i++)
            queryWithIndex[i] = new int[]{queries[i], i};

        // quickSort2D(queryWithIndex, 0, n-1);
        Arrays.sort(queryWithIndex, (a,b) -> a[0] - b[0]);

        int[] answer = new int[n];
        int index = 0;
        int maxBeauty = 0;

        for (int[] query : queryWithIndex) {
            int qPrice = query[0];
            int orgIdx = query[1];

            while (index < m && items[index][0] <= qPrice) {
                maxBeauty = Math.max(maxBeauty, items[index][1]);
                index++;
            }
            answer[orgIdx] = maxBeauty;
        }
        return answer;
    }
    private static void quickSort2D(int[][] arr, int start, int end) {
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
            // keep lesser elements left of the pivot index
            if (compareRow(arr[i], pivot) < 0) {
                swap(arr, pIndex, i);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }
    private static int compareRow(int[] row, int[] pivot) {
        int n = row.length;
        for (int i=0; i<n; i++) {
            if (row[i] < pivot[i])
                return -1;
            else if (row[i] > pivot[i])
                return 1;
        } return 0;
    }
    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Optimized Approach
    public static int[] maximumBeautyOpt(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];
        // sort by the price
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        // update with the maximum beauty till now
        int maxBeauty = items[0][1];

        for (int i=1; i<items.length; i++) {
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        for (int i=0; i<queries.length; i++)
            answer[i] = binarySearch(items, queries[i]);

        return answer;
    }
    private static int binarySearch(int[][] items, int qPrice) {
        int start = 0, end = items.length-1;
        int maxBeauty = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (items[mid][0] > qPrice) {
                end = mid - 1;
            } else {
                maxBeauty = items[mid][1];
                start = mid + 1;
            }
        } return maxBeauty;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}},
                new int[]{1,2,3,4,5,6})));
        System.out.println(Arrays.toString(maximumBeauty(new int[][]{{1,2},{1,2},{1,3},{1,4}}, new int[]{1})));
    }
}
