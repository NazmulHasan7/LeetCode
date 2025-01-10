// 2364. Count Number of Bad Pairs
package Medium;

import java.util.HashMap;

public class Medium_2364_Count_Number_of_Bad_Pairs {
    public static long countBadPairs(int[] nums) {
        // For an array of n numbers
        // n(n-1)/2 pairs can be formed
        // instead of looking for bad pairs -> count for good pairs

        int n = nums.length;
        long pairs = (long) n * (n-1)/2;

        /* j - i == nums[j] - nums[i] => j - nums[j] = i - nums[i]
           for (int i=0; i<n; i++)
           nums[i] = i - nums[i]; */

        long goodPair = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int x = i - nums[i];
            int c = map.getOrDefault(x, 0);
            goodPair += c;
            map.put(x, c+1);
        }
        return pairs - goodPair;
    }
    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4,1,3,3}));
        System.out.println(countBadPairs(new int[]{1,2,3,4,5}));
    }
}
