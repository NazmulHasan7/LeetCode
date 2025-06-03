// 3397. Maximum Number of Distinct Elements After Operations
package Medium;
import java.util.Arrays;

public class Medium_3397_Maximum_Number_of_Distinct_Elements_After_Operations {
    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            int min = num - k;
            int max = num + k;
            if (prev < min) {
                prev = min;
                count++;
            } else if (prev < max) {
                prev = prev + 1;
                count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maxDistinctElements(new int[]{1,2,2,3,3,4},2));
        System.out.println(maxDistinctElements(new int[]{4,4,4,4},1));
    }
}
