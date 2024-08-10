// 1624. Largest Substring Between Two Equal Characters
package Easy;

public class Easy_1624_Largest_Substring_Between_Two_Equal_Characters {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        int maxLength = -1, length = s.length();
        for (int i=0; i<length; i++)
            end[s.charAt(i)-'a'] = i;
        for (int i=length-1; i>=0; i--)
            start[s.charAt(i)-'a'] = i;

        int range;
        for (int i=0; i<length; i++) {
            char c = s.charAt(i);
            range = end[c-'a'] - start[c-'a'] - 1;
            if (range > maxLength)
                maxLength = range;
        } return maxLength;
    }
    public static int maxLengthBetweenEqualCharactersBetter(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;
        int maxLength = -1;
        for (int i=0; i<26; i++)
            if (freq[i] >= 2)
                maxLength = Math.max(maxLength, s.lastIndexOf('a'+i)-s.indexOf('a'+i)-1);
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
    }
}
