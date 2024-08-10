// 2401. Longest Nice Sub-array
package Medium;

public class Medium_2401_Longest_Nice_Subarray {
    public static int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0;
        int answer = 0, bit = 0;

        while (right < nums.length) {
            while ((bit & nums[right]) != 0) {
                // unset the bits set by the left
                // 1 XOR 1 => 0
                bit ^= nums[left];
                left++;
            }
            bit |= nums[right];
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
    }
}
