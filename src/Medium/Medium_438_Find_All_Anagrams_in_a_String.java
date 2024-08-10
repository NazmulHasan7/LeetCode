// 438. Find All Anagrams in a String
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        if (pLen > sLen) return new ArrayList<>();

        int[] freqP = new int[26];
        for (char c : p.toCharArray())
            freqP[c-'a']++;

        int[] currentFreqS = new int[26];
        int left = 0, right;
        for (right=0; right<pLen; right++)
            currentFreqS[s.charAt(right)-'a']++;

        List<Integer> answer = new ArrayList<>();
        if (Arrays.equals(freqP, currentFreqS))
            answer.add(0);

        while (right < sLen) {
            currentFreqS[s.charAt(left++)-'a']--;
            currentFreqS[s.charAt(right++)-'a']++;
            if (Arrays.equals(freqP, currentFreqS))
                answer.add(left);
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}
