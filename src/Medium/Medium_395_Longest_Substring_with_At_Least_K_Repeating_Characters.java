// 395. Longest Substring with At Least K Repeating Characters
package Medium;

public class Medium_395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public static int longestSubstring(String s, int k) {
        // base cases
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;

        // store the frequency of each char
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        int left = 0;
        // look for the chars which has the frequency < k
        // because the resultant substring should not contain this char
        while (left < n && freq[s.charAt(left)-'a'] >= k)
            left++; // when the char is found, split the string into left and right substring
        // check we have checked all the characters
        if (left >= n-1) return left; // reached the end

        int leftMax = longestSubstring(s.substring(0, left), k);

        // ignore the chars which has frequency < k
        while (left < n && freq[s.charAt(left)-'a'] < k)
            left++;

        int rightMax = longestSubstring(s.substring(left), k);
        return Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
}
