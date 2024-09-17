// 2419. Longest Subarray With Maximum Bitwise AND
package Medium;

public class Medium_2419_Longest_Subarray_With_Maximum_Bitwise_AND {
    public static int longestSubarray(int[] nums) {
        // bitwise AND of any two numbers is always less than or equal to any of those numbers
        // the maximum number in the array always has the maximum possible bitwise AND
        int size = 1, maxi = nums[0], answer = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
                size = 1;
                answer = 1;
            } else if (nums[i] == maxi) {
                size++;
            } else {
                size = 0;
            }
            answer = Math.max(size, answer);
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,2,3,3,2,2}));
        System.out.println(longestSubarray(new int[]{1,2,3,4}));
    }
}
