// 983. Minimum Cost For Tickets
package Medium;
import java.util.Arrays;

public class Medium_983_Minimum_Cost_For_Tickets {
    // Recursion + Memoization -> TC O(n) SC O(n)
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]]; // Minimum cost to travel from day[i] to day[n-1]
        Arrays.fill(dp,-1);
        return solve(dp, days, costs, 0, n);
    }
    private static int solve(int[] dp, int[] days, int[] costs, int idx, int n) {
        if (idx >= n) return 0; // out of bound, cannot travel
        if (dp[idx] != -1) return dp[idx];

        int day1pack = costs[0] + solve(dp, days, costs, idx+1, n);

        int day7pack = costs[1];
        int j = idx; // skip 7 days from current day
        while (j < n && days[j] < days[idx] + 7) j++;
        day7pack += solve(dp, days, costs, j, n);

        int day30pack = costs[2];
        j = idx; // skip 30 days from current day
        while (j < n && days[j] < days[idx] + 30) j++;
        day30pack += solve(dp, days, costs, j, n);

        return dp[idx] = Math.min(day1pack, Math.min(day7pack, day30pack));
    }
    // Tabulation
    public static int mincostTicketsTabulation(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n-1];

        int[] dp = new int[lastDay+1]; // minimum cost to travel till day i
        dp[0] = 0; // no cost to travel at day 0

        int idx = 0;
        for (int d=1; d<=lastDay; d++) {
            if (d < days[idx]) {
                dp[d] = dp[d-1];
            } else {
                dp[d] = costs[0] + dp[d-1];
                dp[d] = Math.min(dp[d], dp[Math.max(0, d-7)] + costs[1]);
                dp[d] = Math.min(dp[d], dp[Math.max(0, d-30)] + costs[2]);
                idx++;
            }
        }
        return dp[lastDay];
    }
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
