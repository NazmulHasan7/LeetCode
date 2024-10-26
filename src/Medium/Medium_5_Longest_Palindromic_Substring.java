// 5. Longest Palindromic Substring
package Medium;

public class Medium_5_Longest_Palindromic_Substring {
    // Recursion + Memoization -> TLE
    public static String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n+1][n+1];

        int maxLen = 0, startIdx = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (isPalindrome(s, i, j, dp)) {
                    int len = j-i+1;
                    if (len > maxLen) {
                        maxLen = len;
                        startIdx = i;
                    }
                }
            }
        } return s.substring(startIdx, startIdx+maxLen);
    }
    private static boolean isPalindrome(String s, int left, int right, Boolean[][] dp) {
        if (left >= right) return true;

        if (dp[left][right] != null) return dp[left][right];

        if (s.charAt(left) == s.charAt(right))
            return isPalindrome(s, left+1, right-1, dp);

        return dp[left][right] = false;
    }
    // Optimized Approach
    public String longestPalindromeOptimized(String s) {
        int n = s.length();
        if (n == 0) return "";

        int maxLen = 0, startIdx = 0;

        for (int i = 0; i < n; i++) {
            // Check for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);  // Single center
            if (len1 > maxLen) {
                maxLen = len1;
                startIdx = i - (len1 - 1) / 2;
            }
            // Check for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);  // Double center
            if (len2 > maxLen) {
                maxLen = len2;
                startIdx = i - (len2 - 1) / 2;
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // Expand to the left
            right++; // Expand to the right
        }
        return right - left - 1;  // Return the length of the palindrome
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
