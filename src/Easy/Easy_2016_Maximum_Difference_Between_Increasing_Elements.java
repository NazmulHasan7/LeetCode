// 2016. Maximum Difference Between Increasing Elements
package Easy;

public class Easy_2016_Maximum_Difference_Between_Increasing_Elements {
    public static int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] minInLeft = new int[n];
        minInLeft[0] = nums[0];

        for (int i=1; i<n; i++)
            minInLeft[i] = Math.min(minInLeft[i-1], nums[i]);

        int maxDiff = 0;

        for (int i=1; i<n; i++)
            maxDiff = Math.max(maxDiff, nums[i] - minInLeft[i]);

        if (maxDiff == 0) return -1;
        return maxDiff;
    }
    public static int maximumDifferenceOpt(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int maxDiff = 0;

        for (int i=1; i<n; i++) {
            min = Math.min(min, nums[i]);
            maxDiff = Math.max(maxDiff, nums[i] - min);
        }
        if (maxDiff == 0) return -1;
        return maxDiff;
    }
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7,1,5,4}));
        System.out.println(maximumDifference(new int[]{9,4,3,2}));
        System.out.println(maximumDifference(new int[]{1,5,2,10}));
    }
}
