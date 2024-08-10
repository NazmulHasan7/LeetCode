// 409. Longest Palindrome
package Easy;
import java.util.HashMap;

public class Easy_409_Longest_Palindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        int answer = 0;
        boolean hasOddOccurrence = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                answer += freq;
            } else {
                // Odd occurrence --> consider the closest even count
                answer += freq - 1;
                hasOddOccurrence = true;
            }
        } // ab[c]ba -> c : odd count but the string is palindrome
        if (hasOddOccurrence) // Only one odd frequency is allowed
            return answer + 1;
        return answer;
    }
    public static int longestPalindromeBetter(String s) {
        int[] arrLow = new int[26];
        int[] arrUp = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                arrLow[c-'a']++;
            else arrUp[c-'A']++;
        }

        int answer = 0;
        boolean hasOddOccurrence = false;
        for (int freq : arrLow) {
            if (freq % 2 == 0) {
                answer += freq;
            } else { // Odd occurrence --> consider the closest even count
                answer += freq - 1;
                hasOddOccurrence = true;
            }
        }
        for (int freq : arrUp) {
            if (freq % 2 == 0) {
                answer += freq;
            } else { // Odd occurrence --> consider the closest even count
                answer += freq - 1;
                hasOddOccurrence = true;
            }
        }
        // ab[c]ba -> c : odd count but the string is palindrome
        if (hasOddOccurrence) // Only one odd frequency is allowed
            return answer + 1;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindromeBetter("abccccdd"));
        System.out.println(longestPalindromeBetter("a"));
    }
}
