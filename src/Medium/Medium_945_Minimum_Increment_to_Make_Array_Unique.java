// 945. Minimum Increment to Make Array Unique
package Medium;
import java.util.Arrays;

public class Medium_945_Minimum_Increment_to_Make_Array_Unique {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // System.out.println(Arrays.toString(nums));

        int answer = 0;
        for (int i=1; i<n; i++) {
            if (nums[i-1] >= nums[i]) {
                int increment = nums[i-1] - nums[i] + 1;
                nums[i] += increment;
                answer += increment;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}
