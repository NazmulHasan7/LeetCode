// 169. Majority Element
package Easy;
import java.util.Arrays;
import java.util.HashMap;

public class Easy_169_Majority_Element {
    public static int majorityElement1(int[] nums) {
        // Using sorting --> Linear time and no extra space
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static int majorityElement2(int[] nums) {
        // Using HashMap --> Linear time and extra space
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.length / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) > n)
                return num;
        } return 0;
    }
    // Works only when there is a majority element
    public static int majorityElement3(int[] nums) {
        // Using Moore's Voting Algorithm --> Faster solution
        int count = 0, ME = 0;
        for (int num : nums) {
            if (count == 0) ME = num;
            count += (ME == num) ? 1 : -1;
        } return ME;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[] {3,2,3}));
        System.out.println(majorityElement1(new int[] {2,2,1,1,1,2,2}));
        System.out.println(majorityElement2(new int[] {3,2,3}));
        System.out.println(majorityElement2(new int[] {2,2,1,1,1,2,2}));
        System.out.println(majorityElement3(new int[] {3,2,3}));
        System.out.println(majorityElement3(new int[] {2,2,1,1,1,2,2}));
    }
}
