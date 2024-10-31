// 1269. Number of Ways to Stay in the Same Place After Some Steps
package Hard;

import java.util.Arrays;
import java.util.HashMap;

public class Hard_1269_Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps {
    // MLE -> Memory Limit Exceeded
    private static int MOD = (int) 1E9 + 7;
    public static int numWays(int steps, int arrLen) {
        int[][] dp = new int[arrLen][steps+1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, 0, steps, arrLen) % MOD;
    }
    private static int solve(int[][] dp, int pos, int steps, int n) {
        if (steps == 0)
            return pos == 0 ? 1 : 0;

        if (pos < 0 || pos >= n) return 0;

        if (dp[pos][steps] != -1) return dp[pos][steps];

        int ways = 0;
        ways = (ways + solve(dp, pos, steps-1, n)) % MOD;
        ways = (ways + solve(dp, pos-1, steps-1, n)) % MOD;
        ways = (ways + solve(dp, pos+1, steps-1, n)) % MOD;
        return dp[pos][steps] = ways % MOD;
    }
    public static int solve(HashMap<String, Integer> dp, int pos, int steps, int n){
        if (steps == 0) return pos == 0 ? 1 : 0;
        if (pos < 0 || pos >= n) return 0;

        String str = pos + "_" + steps;
        if(dp.containsKey(str)) return dp.get(str);

        int ways = 0;
        ways = (ways + solve(dp, pos, steps-1, n)) % MOD;
        ways = (ways + solve(dp, pos-1, steps-1, n)) % MOD;
        ways = (ways + solve(dp, pos+1, steps-1, n)) % MOD;

        dp.put(str, ways % MOD);
        return dp.get(str);
    }
    public int numWaysOptimized(int steps, int arrLen) {
        HashMap<String, Integer> map = new HashMap<>();
        return solve(map, 0, steps, arrLen) % MOD;
    }
    public static void main(String[] args) {
        System.out.println(numWays(3,2));
        System.out.println(numWays(2,4));
        System.out.println(numWays(4,2));
    }
}
