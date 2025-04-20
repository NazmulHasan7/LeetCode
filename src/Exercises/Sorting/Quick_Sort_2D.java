package Exercises.Sorting;
import java.util.Arrays;

// Time complexity -> O(m * nlog(n))

public class Quick_Sort_2D {
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
            if (compareRows(arr[i], pivot) < 0) {
                swap(arr, pIndex, i);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static int compareRows(int[] row, int[] pivot) {
        int len = pivot.length;
        for (int i=0; i<len; i++) {
            if (row[i] < pivot[i])
                return -1; // move smaller elements left of the pivot
            else if (row[i] > pivot[i])
                return 1;
        } return 0;
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        // Test 1: Random order
        int[][] matrix1 = {
                {3, 2, 1},
                {1, 5, 9},
                {3, 1, 7},
                {2, 4, 6},
                {1, 2, 3}
        };
        testSort(matrix1, "Random order");

        // Test 2: Already sorted
        int[][] matrix2 = {
                {1, 2, 3},
                {1, 5, 9},
                {2, 4, 6},
                {3, 1, 7},
                {3, 2, 1}
        };
        testSort(matrix2, "Already sorted");

        // Test 3: Reverse order
        int[][] matrix3 = {
                {5, 5, 5},
                {4, 4, 4},
                {3, 3, 3},
                {2, 2, 2},
                {1, 1, 1}
        };
        testSort(matrix3, "Reverse order");

        // Test 4: Same rows
        int[][] matrix4 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        testSort(matrix4, "Same rows");

        // Test 5: Different row lengths (optional, if supported)
        int[][] matrix5 = {
                {1, 2},
                {1, 2, 3},
                {1}
        };
        testSort(matrix5, "Different row lengths"); // Works only if compareRows handles it
    }

    private static void testSort(int[][] matrix, String label) {
        System.out.println("\n== " + label + " ==");
        System.out.println("Before sorting:");
        printMatrix(matrix);

        quickSort2D(matrix, 0, matrix.length - 1);

        System.out.println("After sorting:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
