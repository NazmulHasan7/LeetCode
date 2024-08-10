// 540. Single Element in a Sorted Array
package Medium;

public class Medium_540_Single_Element_in_a_Sorted_Array {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];

        int start = 1, end = n-2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            // Elements left on the unique follows the index pattern of (even, odd)
            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1]))
                // unique is on the right of mid
                start = mid + 1;
            else // unique is on the left of mid
                end = mid - 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
