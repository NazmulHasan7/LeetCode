// 2542. Maximum Subsequence Score
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_2542_Maximum_Subsequence_Score {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++)
            arr[i] = new int[] {nums1[i], nums2[i]};

        // Sort the array based on the nums2 in decreasing order
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        // Maintain a min heap based on nums1 array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long kSum = 0;

        // Calculate sum and push to heap for the first k-1 elements
        for (int i=0; i<k-1; i++) {
            minHeap.add(arr[i][0]);
            kSum += arr[i][0];
        }
        long answer = 0;
        // Loop through the next elements in the array
        for (int i=k-1; i<n; i++) {
            int min = arr[i][1]; // As the array is sorted
            int value = arr[i][0];

            // Add the kth element to the sum and heap
            kSum += value;
            minHeap.add(value);

            // Remove the smallest element from sum and heap
            if (minHeap.size() > k && k > 0)
                kSum -= minHeap.poll();
            answer = Math.max(answer, kSum * min);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,3,3,2},new int[]{2,1,3,4},3));
        System.out.println(maxScore(new int[]{4,2,3,1,1},new int[]{7,5,10,9,6},1));
    }
}
