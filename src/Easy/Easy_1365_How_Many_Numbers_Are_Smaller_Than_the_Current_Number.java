// 1365. How Many Numbers Are Smaller Than the Current Number
package Easy;
import java.util.Arrays;

public class Easy_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    public static int customBinarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                index = mid;
                // continue to search for first occurrence if exist
                end = mid - 1;
            }
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return index;
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] newArray = new int[n];
        System.arraycopy(nums, 0, newArray, 0, n);
        Arrays.sort(newArray);

        for (int i=0; i<n; i++)
            count[i] = customBinarySearch(newArray, nums[i]);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}
