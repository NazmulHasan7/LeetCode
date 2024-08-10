// 49. Group Anagrams
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_49_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] crr = word.toCharArray();
            Arrays.sort(crr);
            String sortedWord = new String(crr);

            if (!map.containsKey(sortedWord))
                map.put(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        } return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        List<List<String>> answer = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> group : answer)
            System.out.println(Arrays.toString(group.toArray()));
    }
}
