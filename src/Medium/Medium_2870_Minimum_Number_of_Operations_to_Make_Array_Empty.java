// 2870. Minimum Number of Operations to Make Array Empty
package Medium;
import java.util.HashMap;

public class Medium_2870_Minimum_Number_of_Operations_to_Make_Array_Empty {
    public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        int count = 0;
        for (int freq : map.values()) {
            // Edge case : the array cannot be made empty
            if (freq == 1) return -1;
            count += freq / 3;
            if (freq % 3 != 0)
                count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println(minOperations(new int[]{2,1,2,2,3,3}));
    }
}
