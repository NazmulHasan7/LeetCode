// 1296. Divide Array in Sets of K Consecutive Numbers
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            if (map.get(x) != 0) {
                for (int i=0; i<k; i++) {
                    if (map.getOrDefault(x+i, 0) == 0)
                        return false;

                    map.put(x + i, map.get(x+i) - 1);
                }
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println(isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(isPossibleDivide(new int[]{1,2,3,4},3));
    }
}
