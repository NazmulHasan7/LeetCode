// 647. Palindromic Substrings
package Medium;

public class Medium_647_Palindromic_Substrings {
    // Recursion + Memoization -> TLE
    public static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        Boolean[][] dp = new Boolean[n+1][n+1];

        for (int i=0; i<n; i++)
            for (int j=i; j<n; j++)
                if (isPalindrome(dp, s.toCharArray(), i, j))
                    count++;
        return count;
    }
    private static boolean isPalindrome(Boolean[][] dp, char[] crr, int s, int e) {
        if (s >= e) return true;

        if (dp[s][e] != null) return dp[s][e];

        if (crr[s] == crr[e])
            return isPalindrome(dp, crr, s+1, e-1);

        return false;
    }
    // Assuming the current index char is middle char of the substring
    // A single char is a palindrome, now we expand in both left and right nad compare the chars
    // in this way we get 1, 3, 5 -> odd length substrings
    // To get even length substrings, we take the current index as the left pointer and curr + 1 index as the right pointer
    public static int countSubstringsOptimized(String s) {
        int n = s.length();
        int count = 0;
        for (int i=0; i<n; i++) {
            count += getPalindromeCount(s, i, i); // odd length palindrome count
            count += getPalindromeCount(s, i, i+1); // even length palindrome count
        }
        return count;
    }
    private static int getPalindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
