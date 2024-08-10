// 1493. Longest Subarray of 1's After Deleting One Element
package Medium;

public class Medium_1493_Longest_Subarray_of_1s_After_Deleting_One_Element {
    public static int longestSubarray(int[] nums) {
        int maxLen = 0, prev0Index = -1;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                // A second zero within the sub-array is found update the length
                if (prev0Index != -1) {
                    maxLen = Math.max(maxLen, right-left-1);
                    left = prev0Index+1;
                } prev0Index = right;
            } right++;
        } // Check the length of last sub-array
        maxLen = Math.max(maxLen, right-left-1);
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
}
