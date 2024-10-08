// 1641. Count Sorted Vowel Strings
package Medium;
import java.util.Arrays;

public class Medium_1641_Count_Sorted_Vowel_Strings {
    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(dp, n, 0);
    }
    private static int solve(int[][] dp, int n, int idx) {
        if (n == 0) return 1;
        if (dp[n][idx] != -1) return dp[n][idx];

        int count = 0;
        for (int i=idx; i<5; i++)
            count += solve(dp, n-1, i);

        return dp[n][idx] = count;
    }
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(33));
    }
}
