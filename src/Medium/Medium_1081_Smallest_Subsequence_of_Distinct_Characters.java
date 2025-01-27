// 1081. Smallest Subsequence of Distinct Characters
package Medium;

public class Medium_1081_Smallest_Subsequence_of_Distinct_Characters {
    public static String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];

        for (int i=0; i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            lastOccurrence[idx] = i;
        }

        StringBuilder stack = new StringBuilder();
        boolean[] inStack = new boolean[26];
        int ptr = -1;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            // Already in stack ? skip it
            if (inStack[idx]) continue;
            // Check if the current char is smaller than the last character and the last one also appear in future
            // then remove the last character from stack
            while (ptr >= 0 && stack.charAt(ptr) > c && i < lastOccurrence[stack.charAt(ptr)-'a']) {
                inStack[stack.charAt(ptr)-'a'] = false;
                stack.deleteCharAt(ptr);
                ptr--;
            }
            stack.append(c);
            inStack[idx] = true;
            ptr++;
        }
        return stack.toString();
    }
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcabc"));
        System.out.println(smallestSubsequence("cbacdcbc"));
    }
}
