// 2099. Find Subsequence of Length K With the Largest Sum
package Easy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class Easy_2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    public static int[] maxSubsequence(int[] nums, int k) {
        // Create a priority queue to find the largest k elements
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < nums.length; i++)
            maxHeap.add(new int[]{nums[i], i});

        // Extract the indices of the largest k elements
        HashSet<Integer> indices = new HashSet<>();
        for (int i = 0; i < k; i++)
            indices.add(Objects.requireNonNull(maxHeap.poll())[1]);

        // Build the subsequence using these indices
        int[] answer = new int[k];
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (indices.contains(i))
                answer[idx++] = nums[i];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2,1,3,3},2)));
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4},3)));
        System.out.println(Arrays.toString(maxSubsequence(new int[]{3,4,3,3},2)));
    }
}
