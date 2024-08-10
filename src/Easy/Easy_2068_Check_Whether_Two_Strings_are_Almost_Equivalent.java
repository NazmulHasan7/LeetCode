// 2068. Check Whether Two Strings are Almost Equivalent
package Easy;

public class Easy_2068_Check_Whether_Two_Strings_are_Almost_Equivalent {
    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freq = new int[26];
        int length = word1.length();
        for (int i=0; i<length; i++) {
            freq[word1.charAt(i)-'a']++;
            freq[word2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++)
            if (Math.abs(freq[i]) > 3)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(checkAlmostEquivalent("zzzyyy", "iiiiii"));
    }
}
