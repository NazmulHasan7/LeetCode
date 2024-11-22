// 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
package Medium;

public class Medium_2918_Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros {
    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long count1 = 0, count2 = 0;

        for (int x : nums1) {
            sum1 += x;
            if (x == 0) count1++;
        }
        for (int x : nums2) {
            sum2 += x;
            if (x == 0) count2++;
        }
        if (count1 == 0 && sum1 < sum2 + count2) return -1;
        if (count2 == 0 && sum2 < sum1 + count1) return -1;
        return Math.max(sum1 + count1, sum2 + count2);
    }
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        System.out.println(minSum(new int[]{2,0,2,0}, new int[]{1,4}));
    }
}
