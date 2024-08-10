// 594. Longest Harmonious Subsequence
package Easy;
import java.util.Arrays;

public class Easy_594_Longest_Harmonious_Subsequence {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=1;
        int maxLen = 0;
        while (right < nums.length) {
            while (nums[right] - nums[left] > 1)
                left++;

            if (nums[right] - nums[left] == 1) {
                maxLen = Math.max(right-left+1, maxLen);
            } right++;
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(findLHS(new int[]{1,2,3,4}));
        System.out.println(findLHS(new int[]{1,1,1,1}));
    }
}
