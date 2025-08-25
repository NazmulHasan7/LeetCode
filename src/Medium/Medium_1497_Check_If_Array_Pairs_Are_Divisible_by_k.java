// 1497. Check If Array Pairs Are Divisible by k
package Medium;

import java.util.HashMap;

public class Medium_1497_Check_If_Array_Pairs_Are_Divisible_by_k {
    public static boolean canArrange(int[] arr, int k) {
        // k - (num % k) is always < k
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int x = ((num % k) + k) % k; // to handle negative numbers
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for (int key : map.keySet()) {
            if (key == 0) {
                if (map.get(key) % 2 != 0) return false;
            } else {
                if ((int) map.get(key) != map.getOrDefault(k - key, 0))
                    return false;
            }
        } return true;
    }
    public static boolean canArrangeOpt(int[] arr, int k) {
        int[] map = new int[k];
        for (int num : arr) {
            int x = ((num % k) + k) % k;
            map[x]++;
        }
        if (map[0] % 2 != 0) return false;

        for (int x=1; x<=k/2; x++) {
            if (map[x] != map[k-x])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canArrangeOpt(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        System.out.println(canArrangeOpt(new int[]{1,2,3,4,5,6}, 7));
        System.out.println(canArrangeOpt(new int[]{1,2,3,4,5,6}, 10));
    }
}
