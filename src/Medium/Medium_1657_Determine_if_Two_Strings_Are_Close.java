// 1657. Determine if Two Strings Are Close
package Medium;
import java.util.Arrays;

public class Medium_1657_Determine_if_Two_Strings_Are_Close {
    // Operation 1 : Swap any two existing characters
    // Operation 2 : Transform every occurrence of one existing character into another existing character
    public static boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray())
            freq1[c-'a']++;

        for (char c : word2.toCharArray())
            freq2[c-'a']++;

        for (int i=0; i<26; i++)
            if ((freq1[i] > 0 && freq2[i] == 0) || (freq2[i] > 0 && freq1[i] == 0))
                return false;

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i=0; i<26; i++)
            if (freq1[i] != freq2[i])
                return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
}
