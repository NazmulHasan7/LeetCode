// 2441. Largest Positive Integer That Exists With Its Negative
package Easy;
import java.util.Arrays;

public class Easy_2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while (start < end) {
            if (nums[start] > 0) return -1;
            else if (nums[start] > -nums[end]) end--;
            else if (nums[start] < -nums[end]) start++;
            else return nums[end];
        } return -1;
    }
    public static int findMaxKBetter(int[] nums) {
        boolean[] negatives = new boolean[1001];
        for (int num: nums)
            if (num < 0) negatives[num] = true;

        int answer = -1;
        for (int num : nums)
            if (num > answer && negatives[num])
                answer = num;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(findMaxK(new int[] {-1,2,-3,3}));
        System.out.println(findMaxK(new int[] {-1,10,6,7,-7,1}));
        System.out.println(findMaxK(new int[] {-10,8,6,7,-2,-3}));
    }
}
