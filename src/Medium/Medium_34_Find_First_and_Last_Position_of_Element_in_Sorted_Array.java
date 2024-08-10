// 34. Find First and Last Position of Element in Sorted Array
package Medium;
import java.util.Arrays;

public class Medium_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int start = getFirstPosition(nums, target);
        int end = getLastPosition(nums, target);
        return new int[] {start, end};
    }
    private static int getFirstPosition(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                pos = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } return pos;
    }
    private static int getLastPosition(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                pos = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } return pos;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
    }
}
