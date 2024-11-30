// 846. Hand of Straights
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Medium_846_Hand_of_Straights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        TreeMap<Integer, Integer> orderedMap = new TreeMap<Integer, Integer>();
        for (int x : hand) // O(n * log(n)) // store the frequencies
            orderedMap.put(x, orderedMap.getOrDefault(x,0)+1);

        // After the assignment to the groups, the map is expected to empty
        while(!orderedMap.isEmpty()) {
            // Get the first element of the group
            int first = orderedMap.firstKey();
            orderedMap.put(first, orderedMap.get(first)-1);
            if (orderedMap.get(first) <= 0)
                orderedMap.remove(first);

            for (int i=1; i<groupSize; i++) {
                if (!orderedMap.containsKey(first+i))
                    return false;

                orderedMap.put(first+i, orderedMap.get(first+i)-1);
                if (orderedMap.get(first+i) <= 0)
                    orderedMap.remove(first+i);
            }
            // System.out.println(orderedMap);
        }
        return true;
    }
    public static boolean isNStraightHandOpt(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for (int x : hand)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : hand) {
            if (map.get(x) != 0) {
                for (int i=0; i<groupSize; i++) {
                    if (map.getOrDefault(x+i, 0) == 0)
                        return false;

                    map.put(x + i, map.get(x+i) - 1);
                }
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5},4));
    }
}
