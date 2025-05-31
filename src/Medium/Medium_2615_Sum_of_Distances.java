// 2615. Sum of Distances
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_2615_Sum_of_Distances {
    public static long[] distance(int[] nums) {
        int n = nums.length;
        // keep track of sum and count
        // 0 -> left sum
        // 1 -> left count
        // 2 -> right sum
        // 3 -> right count
        HashMap<Integer, long[]> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new long[4]);

            long[] values = map.get(nums[i]);
            values[2] += i; // right sum
            values[3] += 1; // right count
        }

        long[] answer = new long[n];

        for (int i=0; i<n; i++) {
            long[] value = map.get(nums[i]);
            value[2] -= i; // reduce right sum
            value[3] -= 1; // reduce right count

            long left = i*value[1] - value[0]; // i * left count - left sum
            long right = value[2] - i*value[3]; // right sum - i * right count
            answer[i] = left + right;

            value[0] += i; // increase left sum
            value[1] += 1; // increase left count
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distance(new int[]{1,3,1,1,2})));
        System.out.println(Arrays.toString(distance(new int[]{0,5,3})));
    }
}
