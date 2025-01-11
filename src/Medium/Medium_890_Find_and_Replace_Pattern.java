// 890. Find and Replace Pattern
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_890_Find_and_Replace_Pattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words)
            if (check(word, pattern))
                answer.add(word);
        return answer;
    }
    private static boolean check(String word, String pattern) {
        int[] wordToPatternMap = new int[26];
        int[] patternToWordMap = new int[26];

        // -1 indicates that these keys were not already mapped
        Arrays.fill(wordToPatternMap, -1);
        Arrays.fill(patternToWordMap, -1);

        int n = word.length();
        for (int i=0; i<n; i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            // Trying to map the char of pattern again to another character of word
            if (wordToPatternMap[w] != -1 && wordToPatternMap[w] != p)
                return false;

            // Trying to map the char of word again to another character of pattern
            if (patternToWordMap[p] != -1 && patternToWordMap[p] != w)
                return false;

            wordToPatternMap[w] = p;
            patternToWordMap[p] = w;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
        System.out.println(findAndReplacePattern(new String[]{"a","b","c"}, "a"));
    }
}
