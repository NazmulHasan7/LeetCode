// 2085. Count Common Words With One Occurrence
package Easy;
import java.util.HashMap;

public class Easy_2085_Count_Common_Words_With_One_Occurrence {
    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String word : words1)
            map1.put(word, map1.getOrDefault(word, 0)+1);
        for (String word : words2)
            if (map1.containsKey(word))
                map2.put(word, map2.getOrDefault(word, 0)+1);
        int count = 0;
        for (String word : words1)
            if (map2.containsKey(word) && map2.get(word) == 1 && map1.get(word) == 1)
                count++;
        return count;
    }
    public static int countWordsBetter(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (String word : words1)
            map1.put(word, map1.getOrDefault(word, 0)+1);
        int count = 0;
        for (String word : words2) {
            Integer occ = map1.get(word);
            if (occ != null && occ <= 1) {
                if (occ == 1) count++;
                    // consider example 3
                else if (occ == 0) count--;
                map1.put(word, occ-1);
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countWords(new String[] {"leetcode","is","amazing","as","is"},
                new String[] {"amazing","leetcode","is"}));
        System.out.println(countWords(new String[] {"b","bb","bbb"}, new String[] {"a","aa","aaa"}));
        System.out.println(countWords(new String[] {"a", "ab"}, new String[] {"a","a","a","ab"}));
    }
}
