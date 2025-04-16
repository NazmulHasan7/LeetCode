// 1590. Make Sum Divisible by P
package Medium;
import java.util.HashMap;

public class Medium_1590_Make_Sum_Divisible_by_P {
    // Brute Force Approach // O(n^2)
    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        int minLen = n;

        for (int num : nums) total += num;
        if (total % p == 0) return 0;

        for (int i=0; i<n; i++) {
            long subSum = 0;
            for (int j=i; j<n; j++) {
                subSum += nums[j];
                long remSum = total - subSum;
                if (remSum % p == 0)
                    minLen = Math.min(minLen, j-i+1);
            }
        }
        return minLen == n ? -1 : minLen;
    }

    // Optimal Approach
    public static int minSubarrayOpt(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;

        for (int num : nums) sum += num;
        if (sum % p == 0) return 0;

        int needed = (int) (sum % p);
        // Store the sum % p and the index it appears
        // prefix mod -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long currentSum = 0;
        int minLen = n;

        for (int i=0; i<n; i++) {
            currentSum += nums[i];
            int currRem = (int) (currentSum % p);
            int target = currRem - needed;
            if (target < 0) target += p;

            if (map.containsKey(target))
                minLen = Math.min(minLen, i-map.get(target));

            map.put(currRem, i);
        }
        return minLen == n ? -1 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3,1,4,2},6));
        System.out.println(minSubarray(new int[]{6,3,5,2},9));
        System.out.println(minSubarray(new int[]{1,2,3},3));
    }
}
