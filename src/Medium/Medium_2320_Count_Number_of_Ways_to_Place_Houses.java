// 2320. Count Number of Ways to Place Houses
package Medium;
import java.util.Arrays;

public class Medium_2320_Count_Number_of_Ways_to_Place_Houses {
    private static long[] dp;
    private static final long mod = (long) 1e9 + 7;

    public static int countHousePlacements(int n) {
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        long count = solve(n) % mod;
        return (int)((count * count) % mod);
    }
    private static long solve(int n) {
        if (n <= 0) // all the plots have been checked
            return 1; // only one way -> do not place any house

        if (dp[n] != -1) return dp[n];

        long usePlot = solve(n-2) % mod; // take one plot, skip next one
        long skipPlot = solve(n-1) % mod; // skip the plot
        return dp[n] = (usePlot + skipPlot) % mod;
    }
    public static void main(String[] args) {
        System.out.println(countHousePlacements(1));
        System.out.println(countHousePlacements(2));
    }
}
