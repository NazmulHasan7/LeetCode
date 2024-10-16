// 2054. Two Best Non-Overlapping Events
package Medium;
import java.util.Arrays;

public class Medium_2054_Two_Best_Non_Overlapping_Events {
    public static int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n+1][3];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(dp, events, 0, n, 0);
    }
    private static int getNextIdx(int[][] events, int start, int end, int target) {
        int answer = end + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (events[mid][0] >= target) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } return answer;
    }
    private static int solve(int[][] dp, int[][] events, int idx, int n, int count) {
        if (idx >= n || count == 2) return 0;
        if (dp[idx][count] != -1) return dp[idx][count];

        int skip = solve(dp, events, idx+1, n, count);
        // Given that the events cannot overlap
        int nextIdx = getNextIdx(events, idx+1, n-1, events[idx][1] + 1);
        int take = events[idx][2] + solve(dp, events, nextIdx, n, count+1);

        return dp[idx][count] = Math.max(take, skip);
    }
    public static void main(String[] args) {
        System.out.println(maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{2,4,3}}));
        System.out.println(maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{1,5,5}}));
        System.out.println(maxTwoEvents(new int[][]{{1,5,3},{1,5,1},{6,6,5}}));
    }
}
