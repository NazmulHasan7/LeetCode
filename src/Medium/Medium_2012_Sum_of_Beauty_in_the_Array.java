// 2012. Sum of Beauty in the Array
package Medium;

public class Medium_2012_Sum_of_Beauty_in_the_Array {
    // Intuition -> Keep track of the max from left to right
    // Keep track of the min from right to left
    public static int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] maxTrack = new int[n];
        int[] minTrack = new int[n];

        maxTrack[0] = nums[0];
        for (int i=1; i<n; i++)
            maxTrack[i] = Math.max(nums[i], maxTrack[i-1]);

        minTrack[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--)
            minTrack[i] = Math.min(nums[i], minTrack[i+1]);

        // maximum from left < nums[i] < minimum from right
        int sum = 0;
        for (int i=1; i<n-1; i++) {
            if (nums[i] > maxTrack[i-1] && nums[i] < minTrack[i+1])
                sum += 2;
            else if (nums[i] > nums[i-1] && nums[i] < nums[i+1])
                sum += 1;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{1,2,3}));
        System.out.println(sumOfBeauties(new int[]{2,4,6,4}));
        System.out.println(sumOfBeauties(new int[]{3,2,1}));
    }
}
