package Exercises.Heap;
import java.util.ArrayList;

// Max Heap implementation in JAVA
public class MaxHeap {
    private ArrayList<Integer> heap;
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public int getMax() {
        if (heap.isEmpty())
            return Integer.MIN_VALUE;
        return heap.get(0);
    }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    // Maintain the heap property
    public void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    public void insert(int value) {
        heap.add(value);
        // insert in the last position then maintain the heap property
        heapifyUp(heap.size()-1);
    }
    public void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int largeIndex = index;

            if (leftChildIndex < size && heap.get(leftChildIndex) > heap.get(index))
                largeIndex = leftChildIndex;

            if (rightChildIndex < size && heap.get(rightChildIndex) > heap.get(index))
                largeIndex = rightChildIndex;

            if (largeIndex != index) {
                swap(largeIndex, index);
                index = largeIndex;
            } else {
                break;
            }
        }
    }
    public int removeMax() {
        if (heap.isEmpty())
            return Integer.MIN_VALUE;

        // swap last with first then maintain the heap property
        int max = heap.get(0);
        int last = heap.removeLast();
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(10);
        System.out.println(heap.heap);
        heap.insert(5);
        System.out.println(heap.heap);
        heap.insert(8);
        System.out.println(heap.heap);
        heap.insert(12);
        System.out.println(heap.heap);
        System.out.println(heap.removeMax());
        System.out.println(heap.heap);
    }
}
