// 2616. Minimize the Maximum Difference of Pairs
package Medium;
import java.util.Arrays;

public class Medium_2616_Minimize_the_Maximum_Difference_of_Pairs {
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, n = nums.length;
        int right = nums[n-1] - nums[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (canFormValidPairs(nums, mid, p)) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        } return answer;
    }
    private static boolean canFormValidPairs(int[] nums, int difference, int p) {
        int count = 0, n = nums.length;
        for (int i=1; i<n; i++) {
            if (nums[i] - nums[i-1] <= difference) {
                count++;
                i++;
                if (count == p) return true;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{10,1,2,7,1,3},2));
        System.out.println(minimizeMax(new int[]{4,2,1,2},1));
    }
}
