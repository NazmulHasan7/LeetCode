// 33. Search in Rotated Sorted Array
package Medium;

public class Medium_33_Search_in_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (nums[mid] == target)
                return mid;

            // Search in the left sorted array
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else left = mid + 1;
            } else { // search in the right sorted array
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            }
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{0}, 1));
    }
}
