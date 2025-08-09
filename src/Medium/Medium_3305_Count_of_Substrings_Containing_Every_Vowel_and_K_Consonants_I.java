// 3305. Count of Substrings Containing Every Vowel and K Consonants I
package Medium;
import java.util.HashMap;

public class Medium_3305_Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_I {
    public static int countOfSubstrings(String word, int k) {
        // convert the problem into a simple sliding window problem
        // look for the substrings that contains all the vowels and AT LEAST k consonant
        // exactly k = at least(k) - at least(k+1)
        return atLeast(word, k) - atLeast(word,k+1);
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private static int atLeast(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>();
        int n = word.length();
        int left = 0, right = 0, consonant = 0;
        int answer = 0;

        while (right < n) {
            char c = word.charAt(right);
            if (isVowel(c))
                vowels.put(c, vowels.getOrDefault(c, 0)+1);
            else consonant++;

            // shrink the window
            while (vowels.size() == 5 && consonant >= k) {
                answer += (n - right);
                char lc = word.charAt(left);
                if (isVowel(lc)) {
                    int count = vowels.get(lc)-1;
                    if (count == 0)
                        vowels.remove(lc);
                    else vowels.put(lc, count);
                } else {
                    consonant--;
                }
                left++;
            }
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq",1));
        System.out.println(countOfSubstrings("aeiou",0));
        System.out.println(countOfSubstrings("ieaouqqieaouqq",1));
    }
}
