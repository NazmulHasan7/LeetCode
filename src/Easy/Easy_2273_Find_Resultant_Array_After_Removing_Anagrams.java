// 2273. Find Resultant Array After Removing Anagrams
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_2273_Find_Resultant_Array_After_Removing_Anagrams {
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] freq = new int[26];
        for (int i=0; i<word1.length(); i++) {
            freq[word1.charAt(i)-'a']++;
            freq[word2.charAt(i)-'a']--;
        }
        for (int f : freq)
            if (f != 0) return false;
        return true;
    }
    public static List<String> removeAnagrams(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i=1; i<words.length; i++) {
            if (!isAnagram(words[i-1], words[i]))
                list.add(words[i]);
        } return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeAnagrams(
                new String[] {"abba","baba","bbaa","cd","cd"}).toArray()));
        System.out.println(Arrays.toString(removeAnagrams(
                new String[] {"a","b","c","d","e"}).toArray()));
    }
}
