// 966. Vowel Spellchecker
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_966_Vowel_Spellchecker {
    static HashSet<String> exactMatch;
    static HashMap<String, String> capMatch;
    static HashMap<String, String> vowelMatch;

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        exactMatch = new HashSet<>();
        capMatch = new HashMap<>();
        vowelMatch = new HashMap<>();

        for (String word : wordlist) {
            exactMatch.add(word);
            String low = word.toLowerCase();
            capMatch.putIfAbsent(low, word);
            vowelMatch.putIfAbsent(deVowel(low), word);
        }

        int n = queries.length;
        String[] answer = new String[n];
        int idx = 0;

        for (String query : queries) {
            if (exactMatch.contains(query)) {
                answer[idx++] = query;
                continue;
            }
            String lowQ = query.toLowerCase();
            if (capMatch.containsKey(lowQ)) {
                answer[idx++] = capMatch.get(lowQ);
                continue;
            }
            String lowQV = deVowel(lowQ);
            answer[idx++] = vowelMatch.getOrDefault(lowQV, "");
        }
        return answer;
    }

    private static String deVowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                sb.append('_');
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spellchecker(new String[]{"KiTe","kite","hare","Hare"},
                new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"})));
        System.out.println(Arrays.toString(spellchecker(new String[]{"yellow"}, new String[]{"YellOw"})));
    }
}
