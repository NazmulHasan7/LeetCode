// 524. Longest Word in Dictionary through Deleting
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_524_Longest_Word_in_Dictionary_through_Deleting {
    public static String findLongestWord(String s, List<String> dictionary) {
        int maxLen = 0, wordLen;
        String answer = "";
        boolean wordPresent;

        for (String word : dictionary) {
            wordLen = word.length();
            wordPresent = false;

            if (wordLen > maxLen || wordLen == maxLen && answer.compareTo(word) > 0) {
                // Check if word can be formed from s while ignoring some of the characters in s
                int idx = 0;
                for (char c : s.toCharArray()) {
                    if (c == word.charAt(idx) && ++idx == wordLen) {
                        wordPresent = true;
                        break;
                    }
                }
                // If the word can be formed and the word is lexicographically greater than the current answer, update it
                if (wordPresent) { maxLen = wordLen; answer = word; }
            }
        } return answer;
    }
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(findLongestWord("abpcplea", dictionary));
    }
}
