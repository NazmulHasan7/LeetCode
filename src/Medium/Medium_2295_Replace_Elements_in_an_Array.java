// 2295. Replace Elements in an Array
package Medium;
import java.util.Arrays;
import java.util.HashMap;

public class Medium_2295_Replace_Elements_in_an_Array {
    public static int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
            map.put(nums[i], i);

        for (int[] op : operations) {
            int pos = map.get(op[0]);
            nums[pos] = op[1];
            map.put(op[1], pos);
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3},{4,7},{6,1}})));
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2}, new int[][]{{1,3},{2,1},{3,2}})));
    }
}
