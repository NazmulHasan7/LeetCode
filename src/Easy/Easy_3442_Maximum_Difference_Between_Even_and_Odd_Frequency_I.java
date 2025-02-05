// 3442. Maximum Difference Between Even and Odd Frequency I
package Easy;

public class Easy_3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I {
    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        int evenFreq = Integer.MAX_VALUE;
        int oddFreq = 0;

        for (int i=0; i<26; i++) {
            if (freq[i] != 0) {
                if ((freq[i] & 1) == 1)
                    oddFreq = Math.max(oddFreq, freq[i]);
                else evenFreq = Math.min(evenFreq, freq[i]);
            }
        } return oddFreq - evenFreq;
    }
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));
    }
}
