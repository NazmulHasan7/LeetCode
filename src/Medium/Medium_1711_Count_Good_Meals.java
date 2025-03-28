// 1711. Count Good Meals
package Medium;
import java.util.HashMap;

public class Medium_1711_Count_Good_Meals {
    public static int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int MOD = 1000000007;

        for (int del : deliciousness)
            map.put(del, map.getOrDefault(del, 0) + 1);

        int count = 0;

        for (int del : deliciousness) {
            for (int power = 0; power < 22; power++) {
                int target = (1 << power) - del;
                if (map.containsKey(target)) {
                    if (target != del)
                        count = (count + map.get(target)) % MOD;
                    else // You can pick any two different foods to make a good meal
                        // meaning we can take different food with same deliciousness
                        // but cannot take same food
                        count = (count + map.get(target)-1) % MOD;
                }
            }
            map.put(del, map.get(del) - 1);
            if (map.get(del) == 0) map.remove(del);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,3,5,7,9}));
        System.out.println(countPairs(new int[]{1,1,1,3,3,3,7}));
    }
}
