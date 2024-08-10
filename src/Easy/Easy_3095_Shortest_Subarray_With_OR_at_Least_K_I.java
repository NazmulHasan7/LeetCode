// 3095. Shortest Subarray With OR at Least K I
package Easy;

public class Easy_3095_Shortest_Subarray_With_OR_at_Least_K_I {
    public static int minimumSubarrayLength(int[] nums, int k) {
        int minLen = nums.length+1;
        int currentOR;
        // Trying all the SubArrays
        for (int i=0; i<nums.length; i++) {
            currentOR = 0;
            for (int j=i; j<nums.length; j++) {
                currentOR |= nums[j];
                if (currentOR >= k) {
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        } return minLen == nums.length+1 ? -1 : minLen;
    }
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1,2,3}, 2));
        System.out.println(minimumSubarrayLength(new int[]{2,1,8}, 10));
        System.out.println(minimumSubarrayLength(new int[]{1,2}, 0));
    }
}