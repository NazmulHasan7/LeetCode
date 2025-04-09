package Exercises.Sorting;
// TC -> O(nlog(n)) SC -> O(log(n)) [stack]
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end); // find partition index
            quickSort(arr, start, partitionIndex-1); // sort the left sub-array
            quickSort(arr, partitionIndex+1, end); // sort the right sub-array
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; // initial pivot
        int pIndex = start; // initial partition index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivot) { // move smaller elements to the left of pivot
                swap(arr, i, pIndex); // swap the larger element than pivot with the pIndex element
                pIndex++; // increment partition index
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
