// 424. Longest Repeating Character Replacement
package Medium;

public class Medium_424_Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int length = s.length();
        int[] freq = new int[26];
        int left = 0, right = 0, maxFreq = 0;
        int answer = 0;

        while (right < length) {
            int idx = s.charAt(right)-'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            // In current window, the count of characters other than the max one should be <= k
            while (right-left+1 - maxFreq > k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            answer = Math.max(answer, right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
