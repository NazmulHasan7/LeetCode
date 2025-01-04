// 1930. Unique Length-3 Palindromic Subsequences
package Medium;
import java.util.Arrays;
import java.util.HashSet;

public class Medium_1930_Unique_Length_3_Palindromic_Subsequences {
    // TC -> O(26 * n) SC -> O(n)
    public static int countPalindromicSubsequence(String s) {
        // For a 3 len subsequence c_c -> 1st and 3rd character have to be same
        // We need to look for the middle character

        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur, -1);

        // find the first and the last occurrence of each character
        int n = s.length();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (firstOccur[idx] == -1)
                firstOccur[idx] = i;
            lastOccur[idx] = i;
        }

        int count = 0;
        for (int i=0; i<26; i++) {
            int first = firstOccur[i];

            if (first == -1)
                continue; // No occurrence of the char

            int last = lastOccur[i];
            if (first == last)
                continue; // Only one occurrence of the char, cannot be the 1st & 3rd char of palindrome

            // To get rid of the duplicates
            HashSet<Character> set = new HashSet<>();
            for (int middle = first+1; middle < last; middle++) {
                set.add(s.charAt(middle));
            }
            // Number of characters in the middle == number of palindromes
            count += set.size();
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}
