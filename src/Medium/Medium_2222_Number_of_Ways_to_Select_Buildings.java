// 2222. Number of Ways to Select Buildings
package Medium;
import java.util.Arrays;

public class Medium_2222_Number_of_Ways_to_Select_Buildings {
    public static long numberOfWays(String s) {
        int n = s.length();
        long[][][] dp = new long[n+1][4][3]; // string, target, prevChar
        for (long[][] dr : dp)
            for (long[] d : dr)
                Arrays.fill(d,-1);

        return solve(dp, s.toCharArray(),0,n,3,'2');
    }
    private static long solve(long[][][] dp, char[] crr, int idx, int n, int count, char prev) {
        if (count == 0) return 1;   // 3 buildings selected
        if (idx >= n) return 0;    // out of bound
        if (dp[idx][count][prev-'0'] != -1)
            return dp[idx][count][prev-'0'];

        long skip = solve(dp, crr, idx+1, n, count, prev);
        long take = 0;
        if (crr[idx] != prev)
            take = solve(dp, crr, idx+1, n, count-1, crr[idx]);

        return dp[idx][count][prev-'0'] = take + skip;
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays("001101"));
        System.out.println(numberOfWays("11100"));
    }
}
