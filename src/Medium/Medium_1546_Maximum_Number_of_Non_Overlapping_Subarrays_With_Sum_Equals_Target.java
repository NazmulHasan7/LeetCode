// 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
package Medium;
import java.util.HashSet;

public class Medium_1546_Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target {
    public static int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        int currSum = 0;
        int count = 0;

        for (int i=0; i<n; i++) {
            currSum += nums[i];
            if (set.contains(currSum - target)) {
                set.clear();
                count++;
            }
            set.add(currSum);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxNonOverlapping(new int[]{1,1,1,1,1},2));
        System.out.println(maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9},6));
    }
}
