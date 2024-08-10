package Exercises.Heap;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapBasics {
    public static void maxHeap(int[] arr) {
        // By default priority queue are in MinHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) maxHeap.add(num);
        System.out.println(maxHeap);
    }
    public static void minHeap(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.add(num);
        System.out.println(minHeap);
    }
    public static void main(String[] args) {
        int[] arr = {1,10,4,5,7};
        maxHeap(arr);
        minHeap(arr);
    }
}
