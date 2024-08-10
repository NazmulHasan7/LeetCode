// 1002. Find Common Characters
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_1002_Find_Common_Characters {
    public static int[] getFrequency(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray())
            freq[c-'a']++;
        return freq;
    }
    public static void getMinFrequency(int[] freq, int[] freq2) {
        for (int i=0; i<26; i++)
            freq[i] = Math.min(freq[i], freq2[i]);
    }
    public static List<String> commonChars(String[] words) {
        int[] freq = getFrequency(words[0]);
        int length = words.length;
        for (int i=1; i<length; i++)
            getMinFrequency(freq, getFrequency(words[i]));

        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<26; i++)
            while (freq[i]-- > 0)
                list.add(String.valueOf((char)(i+'a')));
        return list;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(commonChars(
                new String[] {"bella","label","roller"}).toArray()));
        System.out.println(Arrays.toString(commonChars(
                new String[] {"cool","lock","cook"}).toArray()));
    }
}
