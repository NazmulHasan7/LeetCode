// 3423. Maximum Difference Between Adjacent Elements in a Circular Array
package Easy;

public class Easy_3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array {
    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDif = Math.abs(nums[0] - nums[n-1]);

        for (int i=1; i<n; i++)
            maxDif = Math.max(maxDif, Math.abs(nums[i] - nums[i-1]));

        return maxDif;
    }
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1,2,4}));
        System.out.println(maxAdjacentDistance(new int[]{-5,-10,-5}));
    }
}
