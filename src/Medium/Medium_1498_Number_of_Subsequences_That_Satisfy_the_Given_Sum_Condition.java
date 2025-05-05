// 1498. Number of Subsequences That Satisfy the Given Sum Condition
package Medium;
import java.util.Arrays;

public class Medium_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        int mod = (int)1e9 + 7;
        Arrays.sort(nums);

        // array of 2^ powers to avoid precision loss
        int[] power = new int[n]; // maximum power can be (right-left) -> n-0
        power[0] = 1;
        for (int i=1; i<n; i++)
            power[i] = (power[i-1]*2) % mod;

        int count = 0;

        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                count = (count + power[right-left]) % mod;
                left++;
            } else right--;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3,5,6,7},9));
        System.out.println(numSubseq(new int[]{3,3,6,8},10));
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7},12));
    }
}
