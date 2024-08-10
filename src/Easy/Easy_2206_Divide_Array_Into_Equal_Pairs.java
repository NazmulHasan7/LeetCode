// 2206. Divide Array Into Equal Pairs
package Easy;
import java.util.HashMap;

public class Easy_2206_Divide_Array_Into_Equal_Pairs {
    public static boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        for (int i=0; i<nums.length; i++)
            arr[nums[i]]++;
        for (int num : nums)
            if (arr[num] % 2 != 0) return false;
        return true;
    }
    public static boolean divideArrayHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (int num : nums) {
            if (map.get(num) % 2 != 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(divideArray(new int[] {3,2,3,2,2,2}));
        System.out.println(divideArray(new int[] {1,2,3,4}));
        System.out.println(divideArrayHashMap(new int[] {3,2,3,2,2,2}));
        System.out.println(divideArrayHashMap(new int[] {1,2,3,4}));
    }
}
