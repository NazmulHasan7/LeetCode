// 162. Find Peak Element
package Medium;

public class Medium_162_Find_Peak_Element {
    public static int findPeakElement(int[] nums) {
        // Edge cases
        int n = nums.length;
        if (n == 1) return 0;
        // Since outside neighbors are negative infinite
        if (nums[0] > nums[1])
            return 0;
        if (nums[n-1] > nums[n-2])
            return n-1;

        int start = 1, end = n-2;
        while (start <= end) {
            int mid = (start+end) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
                // Still in increasing order
            else if (nums[mid] < nums[mid+1])
                start = mid + 1;
            else end = mid - 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}