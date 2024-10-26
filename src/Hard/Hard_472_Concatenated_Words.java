// 472. Concatenated Words
package Hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Hard_472_Concatenated_Words {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String, Boolean> dp = new HashMap<>();
        HashSet<String> set = new HashSet<>(List.of(words));

        List<String> answer = new ArrayList<>();
        for (String word : words) {
            // Remove the word to avoid using itself
            set.remove(word);
            if (isConcatenated(dp, set, word))
                answer.add(word);
            // Re-add the word back into the set after checking
            set.add(word);
        }
        return answer;
    }
    private static boolean isConcatenated(HashMap<String, Boolean> dp, HashSet<String> set, String word) {
        if (set.contains(word))
            return true;

        if (dp.containsKey(word))
            return dp.get(word);

        int n = word.length();

        for (int i=0; i<n; i++) {
            String prefix = word.substring(0, i+1);
            String suffix = word.substring(i+1, n);

            if (set.contains(prefix) && (set.contains(suffix) || isConcatenated(dp, set, suffix))) {
                dp.put(word, true);
                return true;
            }
        }
        dp.put(word, false);
        return false;
    }
    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog",
                "hippopotamuses","rat","ratcatdogcat"}));
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","dog","catdog"}));
    }
}
