// 35. Search Insert Position
package Easy;

public class Easy_35_Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        if (target < nums[0]) return 0;
        else if (target > nums[end]) return nums.length;

        int mid = (start + end) / 2;
        while (start <= end) {
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else start = mid + 1;
            mid = (start + end) / 2;
        } return mid + 1;
    }
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(searchInsert(new int[] {1,3}, 2));
    }
}
