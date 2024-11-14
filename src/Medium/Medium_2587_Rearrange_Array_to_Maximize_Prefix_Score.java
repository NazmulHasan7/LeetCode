// 2587. Rearrange Array to Maximize Prefix Score
package Medium;
import java.util.Arrays;

public class Medium_2587_Rearrange_Array_to_Maximize_Prefix_Score {
    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int score = 0;
        long sum = 0;

        for (int i=n-1; i>=0; i--) {
            sum += nums[i];
            if (sum <= 0) break;
            score++;
        }
        return score;
    }
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{2,-1,0,1,-3,3,-3}));
        System.out.println(maxScore(new int[]{-2,-3,0}));
    }
}
