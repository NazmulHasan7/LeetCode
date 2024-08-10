// 703. Kth Largest Element in a Stream
package Easy;
import java.util.PriorityQueue;

public class Easy_703_Kth_Largest_Element_in_a_Stream {
    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();
            for (int num : nums) {
                minHeap.add(num);
                if (minHeap.size() > k) minHeap.poll();
            }
        }
        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) minHeap.poll();
            if (!minHeap.isEmpty()) minHeap.peek();
            return -1;
        }
    }
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}
