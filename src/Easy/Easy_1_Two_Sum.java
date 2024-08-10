// 1. Two Sum
package Easy;
import java.util.Arrays;
import java.util.HashMap;

public class Easy_1_Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        } return result;
    }
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int length = nums.length;
        for (int i=0; i<length-1; i++)
            for (int j=i+1; j<length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[] {i, j};
        return new int[] {0};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {3, 3}, 6)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[] {3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[] {3, 3}, 6)));
    }
}
