// 474. Ones and Zeroes
package Medium;
import java.util.Arrays;

public class Medium_474_Ones_and_Zeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        int[][] zeroOneCount = new int[len][2];
        for (int i=0; i<len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeroOneCount[i][0]++;
                else zeroOneCount[i][1]++;
            }
        }
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int[][] dr : dp)
            for (int[] d : dr)
                Arrays.fill(d, -1);
        return solve(dp, zeroOneCount, 0, len, m, n);
    }
    private static int solve(int[][][] dp, int[][] counts, int idx, int len, int zeroCount, int oneCount) {
        if (idx >= len) return 0; // out of bound

        if (dp[idx][zeroCount][oneCount] != -1)
            return dp[idx][zeroCount][oneCount];

        int skip = solve(dp, counts, idx+1, len, zeroCount, oneCount);
        int take = 0;
        if (zeroCount >= counts[idx][0] && oneCount >= counts[idx][1]) {
            take = 1 + solve(dp, counts, idx+1, len, zeroCount-counts[idx][0], oneCount-counts[idx][1]);
        }
        return dp[idx][zeroCount][oneCount] = Math.max(take, skip);
    }
    // Tabulation Approach
    public static int findMaxFormTabulation(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] -> the largest subset of string that has i 0's and j 1's
        dp[0][0] = 0;

        for (String str : strs) {
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeroCount++;
                else oneCount++;
            }

            for (int i=m; i>=zeroCount; i--) {
                for (int j=n; j>=oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroCount][j-oneCount] + 1);
                }
            }
        } return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
        System.out.println(findMaxForm(new String[]{"10","0","1"},1,1));
    }
}

