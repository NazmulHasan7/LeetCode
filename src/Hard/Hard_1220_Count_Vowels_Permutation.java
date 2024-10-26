// 1220. Count Vowels Permutation
package Hard;
import java.util.Arrays;

public class Hard_1220_Count_Vowels_Permutation {
    private static final int MOD = (int) 1E9 + 7;
    public static int countVowelPermutation(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        long[][] dp = new long[n+1][26];
        for (long[] d : dp) Arrays.fill(d,-1);

        long answer = 0;
        for (char c : vowels) {
            answer = (answer + solve(dp, n-1, c)) % MOD;
        }
        return (int) (answer % MOD);
    }
    private static long solve(long[][] dp, int n, char prev) {
        if (n == 0) return 1; // length reached

        int charIdx = prev - 'a';
        if (dp[n][charIdx] != -1) return dp[n][charIdx];

        long count = 0;
        if (prev == 'a')
            count += solve(dp, n-1, 'e');
        else if (prev == 'e')
            count += solve(dp, n-1, 'a') + solve(dp, n-1, 'i');
        else if (prev == 'i')
            count += solve(dp, n-1, 'a') + solve(dp, n-1, 'e') +
                    solve(dp, n-1, 'o') + solve(dp, n-1, 'u');
        else if (prev == 'o')
            count += solve(dp, n-1, 'i') + solve(dp, n-1, 'u');
        else if (prev == 'u')
            count += solve(dp, n-1, 'a');

        return dp[n][charIdx] = (int) (count % MOD);
    }
    // Optimized
    public static int countVowelPermutationOptimized(int n) {
        long aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;
        int MOD = 1000000007;

        for (int i = 1; i < n; i++) {
            long aCountNew = (eCount + iCount + uCount) % MOD;
            long eCountNew = (aCount + iCount) % MOD;
            long iCountNew = (eCount + oCount) % MOD;
            long oCountNew = (iCount) % MOD;
            long uCountNew = (iCount + oCount) % MOD;
            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }
        long result = (aCount + eCount + iCount + oCount + uCount) % MOD;
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(5));
        System.out.println(countVowelPermutation(2));
    }
}
