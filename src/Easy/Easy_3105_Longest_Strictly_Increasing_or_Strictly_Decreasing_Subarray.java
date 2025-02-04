// 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
package Easy;

public class Easy_3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int incLen = 1, decLen = 1;
        int maxLen = 1;

        for (int i=1; i<n; i++) {
            if (nums[i-1] < nums[i]) {
                incLen++;
                decLen = 1;
            } else if (nums[i-1] > nums[i]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1,4,3,3,2}));
        System.out.println(longestMonotonicSubarray(new int[]{3,3,3,3}));
        System.out.println(longestMonotonicSubarray(new int[]{3,2,1}));
    }
}
