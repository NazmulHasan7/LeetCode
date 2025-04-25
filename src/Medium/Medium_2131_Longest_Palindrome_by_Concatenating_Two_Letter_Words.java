// 2131. Longest Palindrome by Concatenating Two Letter Words
package Medium;
import java.util.HashMap;

public class Medium_2131_Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    public static int longestPalindrome(String[] words) {
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        boolean centerUsed = false; // for aa, bb, bb, cc cases
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                int freq = map.get(word);
                len += (freq / 2) * 4; // bb-aa-aa-bb
                if ((freq & 1) == 1 && !centerUsed) {
                    centerUsed = true;
                    len += 2; // bb-aa-cc-aa-bb
                }
            }
            else { // for cases like ab ba
                if (map.containsKey(word)) {
                    int freq1 = map.get(word);
                    String reverse = String.valueOf(new char[]{word.charAt(1), word.charAt(0)});
                    if (map.containsKey(reverse)) {
                        int minFreq = Math.min(freq1, map.get(reverse));
                        len += (minFreq * 4);
                        map.put(word, 0);
                        map.put(reverse, 0);
                    }
                }
            }
        } return len;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"lc","cl","gg"}));
        System.out.println(longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
        System.out.println(longestPalindrome(new String[]{"cc","ll","xx"}));
    }
}
