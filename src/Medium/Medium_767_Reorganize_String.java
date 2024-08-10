// 767. Reorganize String
package Medium;

public class Medium_767_Reorganize_String {
    public static String reorganizeString(String s) {
        int[] freqArr = new int[26];
        for (char c : s.toCharArray())
            freqArr[c-'a']++;

        // Greedily choose the character with max frequency
        int maxFreq = 0, maxFreqChar = 0;
        for (int i=0; i<26; i++) {
            if (freqArr[i] > maxFreq) {
                maxFreq = freqArr[i];
                maxFreqChar = i;
            }
        }
        // If the maximum frequency is more than half of the size
        // Then it is not recognizable
        if (maxFreq > (s.length()+1) / 2) return "";

        char[] answer = new char[s.length()];
        int idx = 0;

        // First insert the max freq character to the even indices
        while (freqArr[maxFreqChar] > 0) {
            answer[idx] = (char) (maxFreqChar + 'a');
            idx += 2;
            freqArr[maxFreqChar]--;
        }

        // Now insert the other characters to the rest of the indices
        for (int i=0; i<26; i++) {
            // Insert all the current character
            while (freqArr[i]-- > 0) {
                if (idx >= answer.length) idx = 1;
                answer[idx] = (char) (i+'a');
                idx += 2;
            }
        }
        return String.valueOf(answer);
    }
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
