// 2708. Maximum Strength of a Group
package Medium;

public class Medium_2708_Maximum_Strength_of_a_Group {
    public static long maxStrength(int[] nums) {
        long product = 1;
        int maxNeg = Integer.MIN_VALUE;
        int zeroCount = 0;
        int negCount = 0;
        int n = nums.length;

        if (n == 1) return nums[0];

        for (int x : nums) {
            if (x != 0) {
                if (x < 0) {
                    negCount++;
                    maxNeg = Math.max(maxNeg, x);
                }
                product *= x;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount == n) return 0;
        if (negCount == 1 && zeroCount > 0 && zeroCount + negCount == n)
            return 0;
        if ((negCount & 1) == 1) return product / maxNeg;
        return product;
    }
    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{3,-1,-5,2,5,-9}));
        System.out.println(maxStrength(new int[]{-4,-5,-4}));
    }
}
