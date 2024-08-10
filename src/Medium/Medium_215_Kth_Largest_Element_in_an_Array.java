// 215. Kth Largest Element in an Array
package Medium;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Medium_215_Kth_Largest_Element_in_an_Array {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public static int findKthLargestBetter(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) maxHeap.add(n);
        while (k-- > 1) maxHeap.poll();
        if (!maxHeap.isEmpty()) return maxHeap.poll();
        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
