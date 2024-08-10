package Exercises.Sorting;

import java.util.Arrays;

public class Sorting {
    public static int[] insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int j = i-1;
            while (j >= 0 && arr[j+1] < arr[j]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        } return arr;
    }
    public static void main(String[] args) {
        int[] arr = insertionSort(new int[]{4, 1, 6, 3, 8, 8, 13, 10, 11});
        System.out.println(Arrays.toString(arr));
    }
}
