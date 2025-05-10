// 3523. Make Array Non-decreasing
package Medium;

public class Medium_3523_Make_Array_Non_decreasing {
    public static int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int ops = 0;

        for (int i=1; i<n; i++) {
            if (nums[i] < prev)
                ops++;
            else prev = nums[i];
        }
        return n - ops;
    }
    public static void main(String[] args) {
        System.out.println(maximumPossibleSize(new int[]{4,2,5,3,5}));
        System.out.println(maximumPossibleSize(new int[]{1,2,3}));
    }
}
