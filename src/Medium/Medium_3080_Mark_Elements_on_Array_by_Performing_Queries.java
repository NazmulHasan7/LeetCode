// 3080. Mark Elements on Array by Performing Queries
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_3080_Mark_Elements_on_Array_by_Performing_Queries {
    // O(nlog(n) + m.nlog(n))
    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] marked = new boolean[n];

        long sum = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) // sort based on the indices when both are equal
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int i=0; i<n; i++) {
            minHeap.add(new int[]{nums[i], i});
            sum += nums[i];
        }

        int m = queries.length;
        long[] answer = new long[m];

        for (int i=0; i<m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (!marked[index]) {
                marked[index] = true;
                sum -= nums[index];
            } // Already marked ? skip it

            while (!minHeap.isEmpty() && k > 0) {
                int[] values = minHeap.poll();
                if (!marked[values[1]]) {
                    // if the minimum value is already marked skip it
                    k--;
                    sum -= values[0];
                    marked[values[1]] = true;
                }
            } answer[i] = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(unmarkedSumArray(new int[]{1,2,2,1,2,3,1}, new int[][]{{1,2},{3,3},{4,2}})));
        System.out.println(Arrays.toString(unmarkedSumArray(new int[]{1,4,2,3}, new int[][]{{0,1}})));
    }
}
