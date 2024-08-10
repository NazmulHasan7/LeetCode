// 1046. Last Stone Weight
package Easy;
import java.util.Collections;
import java.util.PriorityQueue;

public class Easy_1046_Last_Stone_Weight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) maxHeap.add(stone);
        while (!maxHeap.isEmpty()) {
            int y = maxHeap.poll();
            if (maxHeap.isEmpty()) return y;
            int x = maxHeap.poll();
            if (x != y) maxHeap.add(y - x);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight(new int[]{1}));
    }
}
