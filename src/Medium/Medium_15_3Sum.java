// 15. 3Sum
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_15_3Sum {
    // O(n^2 * nlog(n))
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        // Sorted the array to skip the duplicates
        Arrays.sort(nums);
        int j, k;

        for (int i=0; i<n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue; // skip the duplicate

            j = i + 1;
            k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // to ignore duplicate values for j and k
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
