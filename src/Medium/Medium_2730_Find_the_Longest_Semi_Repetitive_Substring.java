// 2730. Find the Longest Semi-Repetitive Substring
package Medium;

public class Medium_2730_Find_the_Longest_Semi_Repetitive_Substring {
    public static int longestSemiRepetitiveSubstring(String s) {
        int n = s.length(), maxLen = 0;
        if (n == 1) return 1;
        int left = 0, right = 1, count = 0;

        // At most one consecutive pair
        while (right < n) {
            if (s.charAt(right) == s.charAt(right-1))
                count++;
            while (count > 1) {
                if (s.charAt(left) == s.charAt(left+1))
                    count--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestSemiRepetitiveSubstring("52233"));
        System.out.println(longestSemiRepetitiveSubstring("5494"));
    }
}
