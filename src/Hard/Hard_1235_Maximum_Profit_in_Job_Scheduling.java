// 1235. Maximum Profit in Job Scheduling
package Hard;
import java.util.Arrays;

public class Hard_1235_Maximum_Profit_in_Job_Scheduling {
    // TC -> O(n * log(n)), SC -> O(n)
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3]; // start, end, profit

        for (int i=0; i<n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        // Sort based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, arr, 0, n);
    }
    private static int getNextIdx(int[][] arr, int start, int end, int target) {
        int answer = end + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid][0] >= target) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } return answer;
    }
    private static int solve(int[] dp, int[][] arr, int idx, int n) {
        if (idx >= n) return 0; // out of bound, no profit
        if (dp[idx] != -1) return dp[idx];

        // Has to options, take the job or skip the job
        int skip = solve(dp, arr, idx+1, n);
        // search the next job for which the start date >= end day of current job
        int nextIdx = getNextIdx(arr, idx+1, n-1, arr[idx][1]);
        int take = arr[idx][2] + solve(dp, arr, nextIdx, n);

        return dp[idx] = Math.max(take, skip);
    }
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
        System.out.println(jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
        System.out.println(jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}));
    }
}
