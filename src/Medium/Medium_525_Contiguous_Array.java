// 525. Contiguous Array
package Medium;
import java.util.HashMap;

public class Medium_525_Contiguous_Array {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // count of 0 and 1 at index i

        int count = 0;
        int maxLen = 0;

        for (int i=0; i<n; i++) {
            if (nums[i] == 0) count++;
            else count--;
            if (map.containsKey(count)) // within this range the count of 0 & 1 are same
                maxLen = Math.max(maxLen, i - map.get(count));
            else map.put(count, i);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1}));
        System.out.println(findMaxLength(new int[]{0,1,0}));
        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }
}
