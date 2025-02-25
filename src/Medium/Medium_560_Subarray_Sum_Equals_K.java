// 560. Subarray Sum Equals K
package Medium;
import java.util.HashMap;

public class Medium_560_Subarray_Sum_Equals_K {
    // Bruteforce approach -> TC O(n^3) SC O(1) -> TLE
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = 0;
                for (int x=i; x<=j; x++) {
                    sum += nums[x];
                }
                if (sum == k) count++;
            }
        } return count;
    }
    // Bruteforce approach -> TC O(n^2) SC O(1)
    public static int subarraySumBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        } return count;
    }
    // Optimized Approach -> Hashmap and prefix sum -> TC & SC -> O(n)
    public static int subarraySumOpt(int[] nums, int k) {
        int n = nums.length;
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i=0; i<n; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put((sum), map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySumBetter(new int[]{1,1,1}, 2));
        System.out.println(subarraySumBetter(new int[]{1,2,3}, 3));
        System.out.println(subarraySumOpt(new int[]{1,1,1}, 2));
        System.out.println(subarraySumOpt(new int[]{1,2,3}, 3));
    }
}
