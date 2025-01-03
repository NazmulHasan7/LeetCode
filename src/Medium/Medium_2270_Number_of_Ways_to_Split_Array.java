// 2270. Number of Ways to Split Array
package Medium;

public class Medium_2270_Number_of_Ways_to_Split_Array {
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int x : nums) sum += x;

        long leftSum = 0;
        int count = 0;
        for (int i=0; i<n-1; i++) {
            leftSum += nums[i];
            long rightSum = sum - leftSum;
            if (leftSum >= rightSum)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10,4,-8,7}));
        System.out.println(waysToSplitArray(new int[]{2,3,1,0}));
    }
}
