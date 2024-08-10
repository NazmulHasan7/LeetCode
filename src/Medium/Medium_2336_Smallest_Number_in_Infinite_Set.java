// 2336. Smallest Number in Infinite Set
package Medium;
import java.util.PriorityQueue;

public class Medium_2336_Smallest_Number_in_Infinite_Set {
    static class SmallestInfiniteSet {
        int current;
        private static PriorityQueue<Integer> minHeap;
        public SmallestInfiniteSet() {
            current = 1;
            minHeap = new PriorityQueue<>();
        }
        public int popSmallest() {
            if (minHeap.isEmpty()) {
                current++;
                return current - 1;
            } return minHeap.poll();
        }
        public void addBack(int num) {
            if (num < current && !minHeap.contains(num))
                minHeap.add(num);
        }
    }
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
        smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
    }
}
