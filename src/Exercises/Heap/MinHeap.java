package Exercises.Heap;
import java.util.ArrayList;

// Min Heap implementation in JAVA
public class MinHeap {
    private ArrayList<Integer> heap;
    public MinHeap() {
        this.heap = new ArrayList<>();
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public int getMin() {
        if (heap.isEmpty())
            return Integer.MIN_VALUE;
        return heap.get(0);
    }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    // Maintain the heap property
    public void heapifyUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIdx)) {
                swap(index, parentIdx);
                index = parentIdx;
            } else {
                break;
            }
        }
    }
    public void insert(int value) {
        // insert in the last position then maintain the heap property
        heap.add(value);
        heapifyUp(heap.size()-1);
    }
    public void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int smallestIdx = index;
            int leftChildIdx = index * 2 + 1;
            int rightChildIdx = index * 2 + 2;

            if (leftChildIdx < size && heap.get(leftChildIdx) < heap.get(index))
                smallestIdx = leftChildIdx;

            if (rightChildIdx < size && heap.get(rightChildIdx) < heap.get(index))
                smallestIdx = rightChildIdx;

            if (smallestIdx != index) {
                swap(smallestIdx, index);
                index = smallestIdx;
            } else {
                break;
            }
        }
    }
    public int removeMin() {
        if (heap.isEmpty())
            return Integer.MIN_VALUE;

        // swap last with first then maintain the heap property
        int min = heap.get(0);
        int last = heap.removeLast();
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        System.out.println(heap.heap);
        heap.insert(5);
        System.out.println(heap.heap);
        heap.insert(8);
        System.out.println(heap.heap);
        heap.insert(12);
        System.out.println(heap.heap);
        System.out.println(heap.removeMin());
        System.out.println(heap.heap);
    }
}
