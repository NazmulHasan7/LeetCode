// 3702. Longest Subsequence With Non-Zero Bitwise XOR
package Medium;

public class Medium_3702_Longest_Subsequence_With_Non_Zero_Bitwise_XOR {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;

        // if all the numbers are zero, no way we can get a non-zero xor value
        boolean otherThanZero = false;
        int xor = 0;

        for (int num : nums) {
            if (!otherThanZero && num != 0)
                otherThanZero = true;
            xor = xor ^ num;
        }

        if (!otherThanZero) return 0;
        if (xor != 0) return n; // whole array is the answer
        return n-1; // since the xor is 0, removing a number will cause a non-zero xor
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,2,3}));
        System.out.println(longestSubsequence(new int[]{2,3,4}));
    }
}
