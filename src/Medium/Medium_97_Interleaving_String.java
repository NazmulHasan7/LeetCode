// 97. Interleaving String
package Medium;

public class Medium_97_Interleaving_String {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) return false;

        Boolean[][] dp = new Boolean[n1+1][n2+1];
        return solve(dp, s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, n1, n2, n3);
    }
    private static boolean solve(Boolean[][] dp, char[] s1, char[] s2, char[] s3, int i1, int i2, int i3, int n1, int n2, int n3) {
        if (i3 == n3) return true;

        if (dp[i1][i2] != null) return dp[i1][i2];

        boolean answer = false;
        if (i1 < n1 && s1[i1] == s3[i3])
            answer = solve(dp, s1, s2, s3, i1+1, i2, i3+1, n1, n2, n3);

        if (answer) return dp[i1][i2] = true;

        if (i2 < n2 && s2[i2] == s3[i3])
            answer = solve(dp, s1, s2, s3, i1, i2+1, i3+1, n1, n2, n3);

        return dp[i1][i2] = answer;
    }
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("", "", ""));
    }
}
