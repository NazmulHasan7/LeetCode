// 32. Longest Valid Parentheses
package Hard;

public class Hard_32_Longest_Valid_Parentheses {
    public static int longestValidParentheses(String s) {
        // Left-to-right pass alone cannot detect valid substrings that start with extra '('
        // and then close later in the string - example - ()(()
        int open = 0, close = 0, maxLen = 0;

        char[] crr = s.toCharArray();
        int n = crr.length;

        // Left to right pass
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, open + close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;
        // Right to left -> reverse direction
        for (int i=n-1; i>=0; i--) {
            if (crr[i] == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, open + close);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
