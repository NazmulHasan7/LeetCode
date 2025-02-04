// 2420. Find All Good Indices
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2420_Find_All_Good_Indices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;

        // Non-increasing count
        int[] prefix = new int[n];
        prefix[0] = 1;

        for (int i=1; i<n; i++) {
            prefix[i] = 1;
            if (nums[i-1] >= nums[i])
                prefix[i] += prefix[i-1];
        }

        // Non-decreasing count
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            suffix[i] = 1;
            if (nums[i+1] >= nums[i])
                suffix[i] += suffix[i+1];
        }

        List<Integer> answer = new ArrayList<>();
        for (int i=k; i<n-k; i++) {
            if (prefix[i-1] >= k && suffix[i+1] >= k)
                answer.add(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(goodIndices(new int[]{2,1,1,1,3,4,1},2));
        System.out.println(goodIndices(new int[]{2,1,1,2},2));
    }
}
