// 81. Search in Rotated Sorted Array II
package Medium;

public class Medium_81_Search_in_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;

            // Edge case --> [4[start], 0, 1, 4[mid], 4, 4, 4[end]
            // start = mid = end --> shrink the search space
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            // search in left sorted array
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else start = mid + 1;
            } else { // search in the right sorted array
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else end = mid - 1;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(search(new int[]{2,5,6,0,0,1,2},3));
    }
}
