// 1207. Unique Number of Occurrences
package Easy;
import java.util.HashMap;
import java.util.HashSet;

public class Easy_1207_Unique_Number_of_Occurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, ++value);
            } else map.put(num, 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int value : map.values())
            if (!set.add(value))
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[] {1,2}));
        System.out.println(uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
