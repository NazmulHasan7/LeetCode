// 2576. Find the Maximum Number of Marked Indices
package Medium;
import java.util.Arrays;

public class Medium_2576_Find_the_Maximum_Number_of_Marked_Indices {
    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n % 2 == 0 ? n/2 : n/2 + 1;

        int left = 0, right = mid, markCount = 0;
        while (left < mid && right < n) {
            if (2 * nums[left] <= nums[right]) {
                markCount += 2;
                left++;
            } right++;
        }
        return markCount;
    }
    public static void main(String[] args) {
        System.out.println(maxNumOfMarkedIndices(new int[]{3,5,2,4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{9,2,5,4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{7,6,8}));
    }
}
