// 1400. Construct K Palindrome Strings
package Medium;

public class Medium_1400_Construct_K_Palindrome_Strings {
    public static boolean canConstruct(String s, int k) {
         /* Edge cases
         1. Length of s < k -> False -> We do not have k characters
         2. Length of s == k -> True -> Each character is a palindrome of length 1
         annabelle -> aa -> naan, ee -> leel
         a -> 2, n -> 2, b -> 1, e -> 2, l -> 2
         obb occurrence count = 1 < k
         For characters that appear odd number of times, we can place them in the middle of a palindrome
         lebel -> is a palindrome */

        int n = s.length();
        if (n == k) return true;
        if (n < k) return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        int oddFreqCount = 0;
        for (int f : freq)
            if ((f & 1) == 1) oddFreqCount++;

        return oddFreqCount <= k;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
        System.out.println(canConstruct("leetcode", 3));
        System.out.println(canConstruct("true", 4));
    }
}
