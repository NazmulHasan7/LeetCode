package Easy;
import java.util.HashMap;
import java.util.Map;

public class ______test {
    public static String lastNonEmptyString(String s) {
        int[] freq = new int[26];
        int[] lastOccurrence = new int[26];
        int n = s.length();

        // Before the last operation, only the most frequent characters in the original string will remain
        int maxFreq = 0;

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            lastOccurrence[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (freq[i] == maxFreq)
                sb.append((char) ('a' + i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(lastNonEmptyString("aabcbbca"));
        System.out.println(lastNonEmptyString("abcd"));
    }
}
