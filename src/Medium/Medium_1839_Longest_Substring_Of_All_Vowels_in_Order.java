// 1839. Longest Substring Of All Vowels in Order
package Medium;

public class Medium_1839_Longest_Substring_Of_All_Vowels_in_Order {
    public static int longestBeautifulSubstring(String word) {
        int length = word.length();
        if (length < 5) return 0;

        int maxLen = 1, count = 1;
        int left = 0, right = 1;
        char prev = word.charAt(0);

        while (right < length) {
            if (word.charAt(right) == prev) {
                while (right < length && word.charAt(right) == prev)
                    right++;
            } else if (word.charAt(right) > prev) {
                count++;
                prev = word.charAt(right);
                right++;
            } else {
                count = 1;
                prev = word.charAt(right);
                left = right;
                right++;
            }
            if (count == 5)
                maxLen = Math.max(maxLen, right-left+1);
        } return maxLen-1;
    }
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(longestBeautifulSubstring("a"));
    }
}
