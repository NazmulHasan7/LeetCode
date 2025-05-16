// 3035. Maximum Palindromes After Operations
package Medium;
import java.util.Arrays;

public class Medium_3035_Maximum_Palindromes_After_Operations {
    public static int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;
        int[] lengths = new int[n];

        int[] freq = new int[26];
        for (int i=0; i<n; i++) {
            String word = words[i];
            lengths[i] = word.length();

            for (char c : word.toCharArray())
                freq[c-'a']++;
        }

        int evenFreq = 0, oddFreq = 0;
        for (int i=0; i<26; i++) {
            evenFreq += (freq[i] / 2);
            oddFreq += (freq[i] % 2);
        }

        // sort the lengths
        Arrays.sort(lengths);

        int answer = 0;
        for (int len : lengths) {
            if ((len & 1) == 1) {
                if (oddFreq > 0) {
                    oddFreq--; // odd in the middle
                    len--;
                } else if (evenFreq > 0){
                    evenFreq--; // break an even frequency
                    oddFreq++; // after breaking an even freq, 2 odd freq characters formed
                    // one used in the middle, other remains as odd freq
                    len--;
                } else {
                    continue;
                }
            }
            int neededPair = len / 2;
            if (neededPair > evenFreq) break;
            evenFreq -= neededPair;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxPalindromesAfterOperations(new String[]{"abbb","ba","aa"}));
        System.out.println(maxPalindromesAfterOperations(new String[]{"abc","ab"}));
        System.out.println(maxPalindromesAfterOperations(new String[]{"cd","ef","a"}));
    }
}
