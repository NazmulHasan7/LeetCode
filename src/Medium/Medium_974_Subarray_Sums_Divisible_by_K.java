// 974. Subarray Sums Divisible by K
package Medium;
import java.util.HashMap;

public class Medium_974_Subarray_Sums_Divisible_by_K {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0, count = 0;
        // Map -> {remainder, count}
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int rem = sum % k;
            // if we already encountered the same rem before
            // then the sum of in between [prev rem idx -> curr idx] indices is divisible by k
            if (rem < 0) rem += k;

            if (map.containsKey(rem))
                count += map.get(rem);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
    public static int subarraysDivByKOpt(int[] nums, int k) {
        int[] modGroups = new int[k];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int mod = sum % k;
            if (mod < 0) mod += k;
            modGroups[mod]++;
        }

        int count = modGroups[0];
        for (int c : modGroups) {
            count += (c * (c - 1))/2;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        System.out.println(subarraysDivByK(new int[]{5}, 9));
    }
}
