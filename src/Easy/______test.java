package Easy;
import java.util.*;

public class ______test {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            int rem = sum % k;

            // if we get the same remainder means that
            // from previous rem to current rem we have a sum of k
            if (map.containsKey(rem))
                count += map.get(rem);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
        System.out.println(subarraysDivByK(new int[]{5},9));
    }
}
