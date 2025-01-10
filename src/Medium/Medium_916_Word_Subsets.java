// 916. Word Subsets
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_916_Word_Subsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int w1 = words1.length;
        int w2 = words2.length;
        List<String> answer = new ArrayList<>();

        // Store the maximum frequency of each character of words in word2
        int[] bMaxFreq = new int[26];
        for (String s : words2) {
            int[] brr = new int[26];
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                brr[idx]++;
                bMaxFreq[idx] = Math.max(brr[idx], bMaxFreq[idx]);
            }
        }

        // Check for each word is words1
        for (String s : words1) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c-'a']++;
            }
            if (isSubset(arr, bMaxFreq))
                answer.add(s);
        }
        return answer;
    }
    private static boolean isSubset(int[] arr, int[] maxFreq) {
        for (int i=0; i<26; i++) {
            if (arr[i] < maxFreq[i])
                return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","o"}));
        System.out.println(wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"l","e"}));
    }
}
