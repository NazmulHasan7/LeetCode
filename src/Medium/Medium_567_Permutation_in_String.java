// 567. Permutation in String
package Medium;

public class Medium_567_Permutation_in_String {
    private static boolean check(int[] freq1, int[] freq2) {
        for (int i=0; i<26; i++)
            if (freq2[i] < freq1[i])
                return false;
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        // s1's permutation have to be a substring of s2
        if (s1.length() > s2.length()) return false;

        // Window size --> Length of s1
        int[] freqS1 = new int[26];
        for (char c : s1.toCharArray())
            freqS1[c-'a']++;

        int[] freqS2 = new int[26];
        int left = 0, right = s1.length();
        for (int i=left; i<right; i++)
            freqS2[s2.charAt(i)-'a']++;

        if (check(freqS1, freqS2)) return true;
        left++;

        while (right < s2.length()) {
            // Slide the window to right -> remove left and add right
            freqS2[s2.charAt(left-1)-'a']--;
            freqS2[s2.charAt(right)-'a']++;
            if (check(freqS1, freqS2)) return true;
            left++;
            right++;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
