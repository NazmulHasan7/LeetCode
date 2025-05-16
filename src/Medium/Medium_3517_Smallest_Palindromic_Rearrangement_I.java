// 3517. Smallest Palindromic Rearrangement I
package Medium;

public class Medium_3517_Smallest_Palindromic_Rearrangement_I {
    public static String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c-'a']++;

        StringBuilder sb = new StringBuilder();
        char middle = '*';

        for (int i=0; i<26; i++) {
            char c = (char)('a' + i);
            if (freq[i] > 0) {
                if ((freq[i] & 1) == 1)
                    middle = c;
                sb.append(String.valueOf(c).repeat(freq[i] / 2));
            }
        }

        if (sb.length() < s.length()) {
            StringBuilder reversed = new StringBuilder(sb).reverse();
            if (middle != '*') sb.append(middle);
            sb.append(reversed);

        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("z"));
        System.out.println(smallestPalindrome("babab"));
        System.out.println(smallestPalindrome("daccad"));
    }
}
