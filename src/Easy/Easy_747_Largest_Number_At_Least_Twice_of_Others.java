// 747. Largest Number At Least Twice of Others
package Easy;

public class Easy_747_Largest_Number_At_Least_Twice_of_Others {
    public static int dominantIndex(int[] nums) {
        int maxValue = Integer.MIN_VALUE, maxIndex = 0;
        for (int index=0; index<nums.length; index++) {
            if (nums[index] > maxValue) {
                maxValue = nums[index];
                maxIndex = index;
            }
        }
        for (int num : nums)
            if (num != maxValue && maxValue < num * 2)
                return -1;
        return maxIndex;
    }
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[] {3,6,1,0}));
        System.out.println(dominantIndex(new int[] {1,2,3,4}));
    }
}
