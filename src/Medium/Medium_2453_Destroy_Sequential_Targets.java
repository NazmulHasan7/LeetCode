// 2453. Destroy Sequential Targets
package Medium;
import java.util.HashMap;

public class Medium_2453_Destroy_Sequential_Targets {
    public static int destroyTargets(int[] nums, int space) {
        /* Let x = nums[i], y = nums[j]
           x + (space * c) = y
           space * c = y - x
           (space * c) % space = (y - x) % space
           0 = (y - x) % space
           since all the numbers are positive
           y % space = x % space */

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int rem = num % space;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int minSeed = Integer.MAX_VALUE;

        for (int num : nums) {
            int rem = num % space;
            int freq = map.get(rem);
            if (freq > maxFreq) {
                minSeed = num;
                maxFreq = freq;
            } else if (freq == maxFreq) {
                minSeed = Math.min(minSeed, num);
            }
        }
        return minSeed;
    }
    public static void main(String[] args) {
        System.out.println(destroyTargets(new int[]{3,7,8,1,1,5},2));
        System.out.println(destroyTargets(new int[]{1,3,5,2,4,6},2));
        System.out.println(destroyTargets(new int[]{6,2,5},100));
    }
}
