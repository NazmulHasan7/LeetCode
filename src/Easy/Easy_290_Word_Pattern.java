// 290. Word Pattern
package Easy;
import java.util.HashMap;

public class Easy_290_Word_Pattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.getOrDefault(c, null) == null) {
                if (map.containsValue(words[i])) return false;
                else map.put(c, words[i]);
            } else if (!map.get(c).equals(words[i])) return false;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
