// 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
package Medium;
import java.util.Arrays;

public class Medium_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<4; i++)
            answer = Math.min(answer, nums[n-4+i] - nums[i]);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5,3,2,4}));
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
        System.out.println(minDifference(new int[]{3,100,20}));
    }
}
