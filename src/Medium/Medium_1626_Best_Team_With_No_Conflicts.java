// 1626. Best Team With No Conflicts
package Medium;
import java.util.Arrays;

public class Medium_1626_Best_Team_With_No_Conflicts {
    // LIS -> Recursion + Memoization
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, arr, -1, 0, n);
    }
    private static int solve(int[][] dp, int[][] arr, int prevIdx, int idx, int n) {
        if (idx >= n) return 0;
        if (prevIdx != -1 && dp[idx][prevIdx] != -1)
            return dp[idx][prevIdx];

        int take = 0;
        if (prevIdx == -1 || arr[prevIdx][1] <= arr[idx][1])
            take = arr[idx][1] + solve(dp, arr, idx, idx+1, n);

        int skip = solve(dp, arr, prevIdx, idx+1, n);
        if (prevIdx != -1)
            dp[idx][prevIdx] = Math.max(take, skip);

        return Math.max(take, skip);
    }
    // Bottom-up or Tabulation method
    public static int bestTeamScoreBottomUp(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a,b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // dp[i] -> best team score till ith index

        int answer = 0;
        for (int i=0; i<n; i++) {
            dp[i] = arr[i][1];
            for (int j=0; j<i; j++) {
                if (arr[j][1] <= arr[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
        System.out.println(bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
    }
}
