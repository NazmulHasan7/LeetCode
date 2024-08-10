// 1984. Minimum Difference Between Highest and Lowest of K Scores
package Easy;
import java.util.Arrays;

public class Easy_1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {
    // Difference between the highest and the lowest of the k scores is minimized
    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;
        int i=0, j=k-1;
        while (j < n)
            answer = Math.min(answer, nums[j++] - nums[i++]);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] {90}, 1));
        System.out.println(minimumDifference(new int[] {9,4,1,7}, 2));
        System.out.println(minimumDifference(new int[] {87063,61094,44530,21297,95857,93551,9918}, 6));
    }
}
