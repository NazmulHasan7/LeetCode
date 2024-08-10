// 2656. Maximum Sum With Exactly K Elements
package Easy;

public class Easy_2656_Maximum_Sum_With_Exactly_K_Elements {
    public static int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        for (int i=1; i<n; i++)
            if (nums[i] > max) max = nums[i];
        return ((max+k-1) * (max+k) / 2) - (max*(max-1)/2);
    }
    public static int maximizeSumBetter(int[] nums, int k) {
        int max = 0;
        for (int num: nums)
            if (num > max) max = num;
        int sum = 0;
        while (k > 0) {
            sum += max; max++; k--;
        } return sum;
    }
    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[] {1,2,3,4,5}, 3));
        System.out.println(maximizeSum(new int[] {5,5,5}, 2));
    }
}
