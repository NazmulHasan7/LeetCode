// 3264. Final Array State After K Multiplication Operations I
package Easy;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Easy_3264_Final_Array_State_After_K_Multiplication_Operations_I {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority queue -> min heap -> sorted based on value first then on index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (int[] a, int[] b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])
        );
        int n = nums.length;
        for (int i=0; i<n; i++)
            minHeap.add(new int[]{nums[i], i});

        while (k > 0) {
            int[] mini = minHeap.poll();
            minHeap.add(new int[]{mini[0] * multiplier, mini[1]});
            k--;
        }
        while (!minHeap.isEmpty()) {
            int[] temp = minHeap.poll();
            nums[temp[1]] = temp[0];
        }
        return nums;
    }
    // Brute force approach
    public static int[] getFinalStateBruteForce(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for (int op = 0; op < k; op++) {
            int minIdx = 0;
            int min = nums[0];

            for (int i=0; i<n; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIdx = i;
                }
            }
            nums[minIdx] = min * multiplier;
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        System.out.println(Arrays.toString(getFinalState(new int[]{1, 2}, 3, 4)));
    }
}
