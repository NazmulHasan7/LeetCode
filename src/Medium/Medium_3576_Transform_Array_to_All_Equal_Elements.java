// 3576. Transform Array to All Equal Elements
package Medium;
import java.util.Arrays;

public class Medium_3576_Transform_Array_to_All_Equal_Elements {
    public static boolean canMakeEqual(int[] nums, int k) {
        int operations = 0;
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);

        // try converting all the numbers to 1
        for (int i=0; i<n-1; i++) {
            if (temp[i] == -1) {
                temp[i] *= -1;
                temp[i+1] *= -1;
                operations++;
            }
            if (operations > k) break;
        }
        if (check(temp) && operations <= k)
            return true;

        temp = Arrays.copyOf(nums, n);
        operations = 0;
        // try converting all the numbers to -1
        for (int i=0; i<n-1; i++) {
            if (temp[i] == 1) {
                temp[i] *= -1;
                temp[i+1] *= -1;
                operations++;
            }
            if (operations > k) return false;
        }
        return check(temp);
    }
    private static boolean check (int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++)
            if (nums[i] != nums[i+1])
                return false;
        return true;
    }

    // Optimized - less code approach
    public static boolean canMakeEqualOpt(int[] nums, int k) {
        return checkOpt(nums.clone(), 1, k) || checkOpt(nums.clone(), -1, k);
    }
    private static boolean checkOpt(int[] nums, int target, int k) {
        int n = nums.length;
        int operations = 0;

        for (int i=0; i<n-1; i++) {
            if (nums[i] != target) {
                nums[i] *= -1;
                nums[i+1] *= -1;
                operations++;
                if (operations > k) return false;
            }
        } return nums[n-1] == target;
    }
    public static void main(String[] args) {
        System.out.println(canMakeEqual(new int[]{1,-1,1,-1,1},3));
        System.out.println(canMakeEqual(new int[]{-1,-1,-1,1,1,1},5));
    }
}
