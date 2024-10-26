// 115. Distinct Subsequences
package Hard;

import java.util.Arrays;

public class Hard_115_Distinct_Subsequences {
    // Recursion + Memoization -> TC & SC -> O(sn * tn)
    public static int numDistinct(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        char[] srr = s.toCharArray();
        char[] trr = t.toCharArray();

        int[][] dp = new int[sn+1][tn+1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(dp, srr, trr, 0, 0, sn, tn);
    }
    private static int solve(int[][] dp, char[] srr, char[] trr, int si, int ti, int sn, int tn) {
        if (ti == tn) // All the characters of the target string is covered
            return 1; // we have found a valid subsequence
        if (si == sn) // All the chars of string s is covered
            return 0;

        if (dp[si][ti] != -1) return dp[si][ti];

        if (srr[si] == trr[ti] || sn - si < tn -ti) {
            // if the characters matches, we have two options to choose
            // take the current character or skip it
            dp[si][ti] = solve(dp, srr, trr, si+1, ti+1, sn, tn); // take
            dp[si][ti] += solve(dp, srr, trr, si+1, ti, sn, tn); // skip
        } else {
            // if the characters do not match, we only have one option to skip it
            dp[si][ti] = solve(dp, srr, trr, si+1, ti, sn, tn);
        }
        return dp[si][ti];
    }
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
