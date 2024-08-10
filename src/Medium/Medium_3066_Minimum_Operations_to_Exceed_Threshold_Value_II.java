// 3066. Minimum Operations to Exceed Threshold Value II
package Medium;
import java.util.PriorityQueue;

public class Medium_3066_Minimum_Operations_to_Exceed_Threshold_Value_II {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int x : nums) minHeap.add((long)x);

        int ops = 0;
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            ops++;
            minHeap.add(minHeap.poll() * 2 + minHeap.poll());
        }
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,11,10,1,3},10));
        System.out.println(minOperations(new int[]{1,1,2,4,9},20));
    }
}
