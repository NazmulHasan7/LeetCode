// 140. Word Break II
package Hard;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hard_140_Word_Break_II {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();
        HashSet<String> dictionary = new HashSet<>(wordDict);
        backtrack(s, dictionary, new StringBuilder(), answer, 0);
        return answer;
    }
    private static void backtrack(String s, HashSet<String> dict, StringBuilder sb, List<String> answer, int index) {
        if (index == s.length()) {
            answer.add(sb.toString().stripTrailing());
            return;
        }
        for (int end = index+1; end <= s.length(); end++) {
            String currentWord = s.substring(index, end);
            if (dict.contains(currentWord)) {
                int lengthBeforePick = sb.length();
                sb.append(currentWord).append(" ");
                backtrack(s, dict, sb, answer, end);
                sb.setLength(lengthBeforePick);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", new ArrayList<>(List.of("cat","cats","and","sand","dog"))));
        System.out.println(wordBreak("pineapplepenapple", new ArrayList<>(List.of("apple","pen","applepen","pine","pineapple"))));
    }
}
