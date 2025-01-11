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


    // O(n*m) -> (length of strs * average size of strings in str)
    public static List<List<String>> groupAnagramsOpt(String[] strs) {
        // Key -> (aab) -> a2b1
        // HashMap<String, List<String>> frequencyStringMap = new HashMap<>();

        /* for (String str : strs) {
            String key = getKey(str);
            if (!frequencyStringMap.containsKey(key)) {
                List<String> group = new ArrayList<>();
                frequencyStringMap.put(key, group);
            }
            frequencyStringMap.get(key).add(str);
        } */
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        // return new ArrayList<>(frequencyStringMap.values());
        return new ArrayList<>(groups.values());
    }
    private static String getKey(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (freq[i] > 0)
                sb.append('a' + i).append(freq[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }
}
