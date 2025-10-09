// 3701. Compute Alternating Sum
package Easy;

public class Easy_3701_Compute_Alternating_Sum {
    public static int alternatingSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            if ((i & 1) == 0) sum += nums[i];
            else sum -= nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(alternatingSum(new int[]{1,3,5,7}));
        System.out.println(alternatingSum(new int[]{100}));
    }
}
