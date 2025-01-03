// 2256. Minimum Average Difference
package Medium;

public class Medium_2256_Minimum_Average_Difference {
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int x : nums) sum += x;

        long leftSum = 0;
        long minAvg = Integer.MAX_VALUE;
        int index = -1;

        for (int i=0; i<n; i++) {
            leftSum += nums[i];
            long leftAvg = leftSum / (i+1);
            long rightAvg = (n-1 == i) ? 0 : (sum - leftSum) / (n-i-1);
            long diff = Math.abs(leftAvg - rightAvg);

            if (diff < minAvg) {
                minAvg = diff;
                index = i;
            }
        } return index;
    }
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[]{2,5,3,9,5,3}));
        System.out.println(minimumAverageDifference(new int[]{0}));
    }
}
