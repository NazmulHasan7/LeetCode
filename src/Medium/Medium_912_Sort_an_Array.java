// 912. Sort an Array
package Medium;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class Medium_912_Sort_an_Array {
    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] sortedArr = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) minHeap.add(x);

        for (int index = 0; index < n; index++)
            sortedArr[index] = Objects.requireNonNull(minHeap.poll());
        return sortedArr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5,2,3,1})));
        System.out.println(Arrays.toString(sortArray(new int[]{5,1,1,2,0,0})));
    }
}
