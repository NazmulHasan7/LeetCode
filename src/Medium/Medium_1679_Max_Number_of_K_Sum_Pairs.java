// 1679. Max Number of K-Sum Pairs
package Medium;
import java.util.Arrays;

public class Medium_1679_Max_Number_of_K_Sum_Pairs {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        int sum, count = 0;
        while (start < end) {
            sum = nums[start] + nums[end];
            if (sum == k) {
                count++;
                start++;
                end--;
            }
            else if (sum < k) start++;
            else end--;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
