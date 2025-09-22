// 3541. Find Most Frequent Vowel and Consonant
package Easy;

public class Easy_3541_Find_Most_Frequent_Vowel_and_Consonant {
    public static int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        int evenMax = 0, oddMax = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = c - 'a';
            if (isVowel(c)) oddMax = Math.max(oddMax, freq[idx]);
            else evenMax = Math.max(evenMax, freq[idx]);
        }
        return evenMax + oddMax;
    }
    private static boolean isVowel (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes"));
        System.out.println(maxFreqSum("aeiaeia"));
    }
}
