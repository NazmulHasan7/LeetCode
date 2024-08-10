// 2558. Take Gifts From the Richest Pile
package Easy;
import java.util.Collections;
import java.util.PriorityQueue;

public class Easy_2558_Take_Gifts_From_the_Richest_Pile {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int g : gifts) maxHeap.add(g);
        while (k-- > 0)
            if (!maxHeap.isEmpty())
                maxHeap.add((int)(Math.sqrt(maxHeap.poll())));

        long sum = 0;
        for (int x : maxHeap) sum += x;
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25,64,9,4,100}, 4));
        System.out.println(pickGifts(new int[]{1,1,1,1}, 4));
    }
}
