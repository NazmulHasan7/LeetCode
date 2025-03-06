// 2261. K Divisible Elements Subarrays
package Medium;
import java.util.HashSet;

public class Medium_2261_K_Divisible_Elements_Subarrays {
    // TC -> O(n^2), SC -> O(n)
    public static int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();

        // Generate all possible sub-array
        for (int i=0; i<n; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j=i; j<n; j++) {
                if (nums[j] % p == 0)
                    count++;

                if (count > k) break;
                // at most k elements that are divisible by p
                sb.append(nums[j]).append("_");
                set.add(sb.toString());
            }
        } return set.size();
    }
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{2,3,3,2,2},2,2));
        System.out.println(countDistinct(new int[]{1,2,3,4},4,1));
    }
}
