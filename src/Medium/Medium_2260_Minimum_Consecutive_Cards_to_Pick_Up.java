// 2260. Minimum Consecutive Cards to Pick Up
package Medium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Medium_2260_Minimum_Consecutive_Cards_to_Pick_Up {
    public static int minimumCardPickup(int[] cards) {
        int minLen = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int idx=0; idx<cards.length; idx++) {
            if (map.containsKey(cards[idx]))
                minLen = Math.min(minLen, idx - map.get(cards[idx]) + 1);
            map.put(cards[idx], idx);
        } return minLen == Integer.MAX_VALUE ? - 1 : minLen;
    }
    public int minimumCardPickupBetter(int[] cards) {
        Set<Integer> picked = new HashSet<>();
        int start = 0, end = 1;
        int res = Integer.MAX_VALUE;
        picked.add(cards[start]);

        while(end<cards.length) {
            if(!picked.contains(cards[end])){
                picked.add(cards[end]);
            } else {
                while(cards[start] != cards[end]){
                    picked.remove(cards[start]);
                    start++;
                }
                res = Math.min(res, end-start+1);
                start++;
            } end++;
        } return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{3,4,2,3,4,7}));
        System.out.println(minimumCardPickup(new int[]{1,0,5,3}));
    }
}
