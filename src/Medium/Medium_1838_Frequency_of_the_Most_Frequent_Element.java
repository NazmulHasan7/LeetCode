// 1838. Frequency of the Most Frequent Element
package Medium;
import java.util.Arrays;

public class Medium_1838_Frequency_of_the_Most_Frequent_Element {
    public static int maxFrequency(int[] nums, int k) {
        // Sliding window Approach
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        long cSum = 0;
        int maxFreq = 1;

        for (int right=0; right<n; right++) {
            cSum += nums[right];
            int target = nums[right];
            long expectedSum = (long) (right-left+1) * target;

            while (expectedSum - cSum > k) {
                expectedSum -= target;
                cSum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, (right-left+1));
        }
        return maxFreq;
    }
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1,2,4},5));
        System.out.println(maxFrequency(new int[]{1,4,8,13},5));
        System.out.println(maxFrequency(new int[]{3,9,6},2));
    }
}
