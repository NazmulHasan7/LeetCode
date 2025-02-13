// 16. 3Sum Closest
package Medium;
import java.util.Arrays;

public class Medium_16_3Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int answer = 0;

        for (int i=0; i<n; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    answer = sum;
                    minDiff = diff;
                } else if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
    }
}
