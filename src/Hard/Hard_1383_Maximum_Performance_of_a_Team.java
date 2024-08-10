// 1383. Maximum Performance of a Team
package Hard;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Hard_1383_Maximum_Performance_of_a_Team {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i=0; i<n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        // Sort the engineers based on the efficiency in decreasing order
        Arrays.sort(engineers, (e1, e2) -> (e2[0] - e1[0]));
        // Maintain a minHeap for the speed of engineers
        PriorityQueue<Integer> speedMinHeap = new PriorityQueue<>(k);
        long teamScore = 0, teamSpeed = 0;

        for (int[] engineer : engineers) {
            // As we can only form a team with max k engineers
            if (speedMinHeap.size() == k && k > 0) {
                // Remove the engineer with the slowest speed
                teamSpeed -= speedMinHeap.poll();
            }
            speedMinHeap.add(engineer[1]);
            teamSpeed += engineer[1];
            // As the array is sorted based on efficiency
            // by default the next engineer has the minimum efficiency
            teamScore = Math.max(teamScore, teamSpeed * engineer[0]);
        }
        return (int) (teamScore % 1000000007);
    }
    public static void main(String[] args) {
        System.out.println(maxPerformance(6,new int[]{2,10,3,1,5,8},new int[]{5,4,3,9,7,2},2));
        System.out.println(maxPerformance(6,new int[]{2,10,3,1,5,8},new int[]{5,4,3,9,7,2},3));
        System.out.println(maxPerformance(6,new int[]{2,10,3,1,5,8},new int[]{5,4,3,9,7,2},4));
    }
}
