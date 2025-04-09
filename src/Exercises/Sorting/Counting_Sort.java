/*  Counting sort algorithm
    1. Find out the maximum element (let it be max) from the given array
    2. Initialize an array of length max+1 with all elements 0.
       This array is used for storing the count of the elements in the array.
    3. Store the count of each element at their respective index in count array.
    4. Store cumulative sum of the elements of the count array.
       It helps in placing the elements into the correct index of the sorted array.
    5. Find the index of each element of the original array in the count array. This gives the cumulative count.
    6. After placing each element at its correct position, decrease its count by one.

    countingSort(array, size)
      max <- find the largest element in array
      initialize count array with all zeros
      for j <- 0 to size
        find the total count of each unique element and
        store the count at jth index in count array
      for i <- 1 to max
        find the cumulative sum and store it in count array itself
      for j <- size down to 1
        restore the elements to array
        decrease count of each element restored by 1
*/
package Exercises.Sorting;
import java.util.Arrays;

public class Counting_Sort {
    public static int[] countSort(int[] array, int size) {

        // Find the largest element of the array
        int max = array[0];
        for (int i=1; i<size; i++)
            if (array[i] > max)
                max = array[i];

        int[] count = new int[max+1];
        // Store the count of each element
        for (int i=0; i<size; i++) count[array[i]]++;

        int idx = 0;
        for (int i=0; i<=max; i++) {
            while (count[i] > 0) {
                array[idx] = i;
                idx++;
                count[i]--;
            }
        } return array;
    }

    public static void main(String[] args) {
        int[] data = { 4, 2, 2, 8, 3, 3, 1 };
        int size = data.length;
        countSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
