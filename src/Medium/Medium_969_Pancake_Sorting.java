// 969. Pancake Sorting
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_969_Pancake_Sorting {
    /*
    The main aim to convert given array to the sorted array
    --> array [3,2,4,1]
    --> index [0 1 2 3]

    end = 4;
    findMax -> idx = 2 -> [3,2,4,1]
    flip from 0 to 2      [4,2,3,1]
    flip from 0 to end-1  [1,3,2,4]
    Result -> [3,4]

    end = 3;
    findMax -> idx = 1 -> [1,3,2,4]
    flip from 0 to 1      [3,1,2,4]
    flip from 0 to end-1  [2,1,3,4]
    Result -> [3,4,2,3]

    end = 2;
    findMax -> idx = 0 -> [2,1,3,4]
    flip from 0 to 1      [1,2,3,4]
    flip from 0 to end-1  [1,2,3,4]
    Result -> [3,4,2,3,1,2]

    end = 1;
    */
    private static int findMaxIndex (int[] arr, int max) {
        for (int i=0; i<arr.length; i++)
            if (arr[i] == max) return i;
        return -1;
    }
    private static void reverse (int[] arr, int end) {
        int start = 0, temp;
        while (start < end) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
    // All the values in array are unique and in between 1 to Length
    // Find max element index
    // Reverse the array from start to max element index --> max goes at index 0
    // Reverse the whole array again --> max goes to the end, that part becomes sorted
    // Repeat the process
    public static List<Integer> pancakeSort(int[] arr) {
        int end = arr.length;
        List<Integer> answer = new ArrayList<>();
        int maxIndex;

        while (end > 1) {
            maxIndex = findMaxIndex(arr, end);
            // reverse acts as flip here
            reverse(arr, maxIndex);
            reverse(arr, end-1);

            answer.add(maxIndex+1);
            answer.add(end);
            end--;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pancakeSort(new int[]{3,2,4,1}).toArray()));
        System.out.println(Arrays.toString(pancakeSort(new int[]{1,2,3}).toArray()));
    }
}
