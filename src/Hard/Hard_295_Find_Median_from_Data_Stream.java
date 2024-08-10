// 295. Find Median from Data Stream
package Hard;
import java.util.PriorityQueue;

public class Hard_295_Find_Median_from_Data_Stream {
    static class MedianFinder {
        PriorityQueue<Integer> leftMaxHeap;
        PriorityQueue<Integer> rightMinHeap;
        MedianFinder () {
            // For odd number of elements, left max heap always contains that extra element
            rightMinHeap = new PriorityQueue<>();
            leftMaxHeap = new PriorityQueue<>((a,b) -> (b-a));
        }
        public void addNum(int num) {
            if (leftMaxHeap.isEmpty() || (num < leftMaxHeap.peek()))
                leftMaxHeap.add(num); // Keep elements is sorted order
            else rightMinHeap.add(num);

            // Maintain the property for odd # of elements 1 + n/2, n/2
            if (leftMaxHeap.size() - rightMinHeap.size() > 1)
                rightMinHeap.add(leftMaxHeap.poll());
            else if (rightMinHeap.size() > leftMaxHeap.size())
                leftMaxHeap.add(rightMinHeap.poll());
        }
        public double findMedian() {
            if (rightMinHeap.size() == leftMaxHeap.size()) // Even
                return (rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
            else return (double) leftMaxHeap.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
