// 209. Minimum Size Subarray Sum
package Medium;

public class Medium_209_Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                minLen = Math.min(minLen, right-left+1);
                left++;
            } right++;
        } return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
    }
}