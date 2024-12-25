// 2462. Total Cost to Hire K Workers
// O(k⋅candidates⋅log(candidates))
package Medium;
import java.util.PriorityQueue;

public class Medium_2462_Total_Cost_to_Hire_K_Workers {
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> minHeapStart = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapEnd = new PriorityQueue<>();

        int start = 0, end = n-1;
        long answer = 0;

        while (k-- > 0) { // k hiring sessions
            // why start <= end ? -> think about the second while loop ends by end--
            // end is now 1 step ahead of where it should be
            while (minHeapStart.size() < candidates && start <= end) {
                minHeapStart.add(costs[start]);
                start++;
            }
            while (minHeapEnd.size() < candidates && end >= start) {
                minHeapEnd.add(costs[end]);
                end--;
            }
            int startMin = minHeapStart.isEmpty() ? Integer.MAX_VALUE : minHeapStart.peek();
            int endMin = minHeapEnd.isEmpty() ? Integer.MAX_VALUE : minHeapEnd.peek();

            if (startMin <= endMin) {
                answer += startMin;
                minHeapStart.poll();
            } else {
                answer += endMin;
                minHeapEnd.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(totalCost(new int[]{1,2,4,1}, 3, 3));
    }
}
