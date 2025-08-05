// 954. Array of Doubled Pairs
package Medium;
import java.util.TreeMap;

public class Medium_954_Array_of_Doubled_Pairs {
    public static boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0)+1);

        for (int num : map.keySet()) {
            int count = map.get(num);
            if (count == 0) continue; // already used

            if (num < 0 && num % 2 != 0)
                return false; // for odd num/2 would not be integer, e.g., -3 / 2 is -1.5

            int target = num >= 0 ? num * 2 : num / 2; // since the map is sorted
            // for negative values like -4 (comes first), target value should be -2
            int count2 = map.getOrDefault(target, 0);

            if (count2 < count) return false;
            map.put(num, 0);
            map.put(target, count2 - count);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{3,1,3,6}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(canReorderDoubled(new int[]{4,-2,2,-4}));
    }
}
