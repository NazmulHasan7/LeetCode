// 2414. Length of the Longest Alphabetical Continuous Substring
package Medium;

public class Medium_2414_Length_of_the_Longest_Alphabetical_Continuous_Substring {
    public static int longestContinuousSubstring(String s) {
        char prev = ' ';
        int count = 1, longest = 0;
        for (char c : s.toCharArray()) {
            if (c == (char) (prev + 1)) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
            prev = c;
        } return Math.max(longest, count);
    }
    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abacaba"));
        System.out.println(longestContinuousSubstring("abcde"));
    }
}
