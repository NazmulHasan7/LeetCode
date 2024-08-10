// 1456. Maximum Number of Vowels in a Substring of Given Length
package Medium;

public class Medium_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static int maxVowels(String s, int k) {
        int maxCount = 0, count = 0;
        int left = 0, right = k;
        for (int i=left; i<right; i++)
            if (isVowel(s.charAt(i))) count++;
        maxCount = count;

        left++;
        while (right < s.length()) {
            if (isVowel(s.charAt(left-1))) count--;
            if (isVowel(s.charAt(right))) count++;
            maxCount = Math.max(maxCount, count);
            left++;
            right++;
        } return maxCount;
    }
    public static int maxVowelsBetter(String s, int k) {
        int count = 0, maxCount = 0, p = 0;
        char[] words = s.toCharArray();
        boolean[] vowels = new boolean[128];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = true;

        for (int i=0; i<k; i++, p++)
            if (vowels[words[i]]) count++;

        maxCount = count;
        if (k == maxCount) return k;

        for (int i=1; p<words.length; i++, p++) {
            if (vowels[words[i-1]]) count--;
            if (vowels[words[p]]) count++;
            maxCount = Math.max(count, maxCount);
            if(k == maxCount) return maxCount;
        } return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("novowels", 1));
    }
}