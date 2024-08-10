// 3090. Maximum Length Substring With Two Occurrences
package Easy;

public class Easy_3090_Maximum_Length_Substring_With_Two_Occurrences {
    public static int maximumLengthSubstring(String s) {
        int[] freqArr = new int[26];
        int maxLen = 0, left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            freqArr[c-'a']++;
            while (left <= right && freqArr[c-'a'] > 2) {
                freqArr[s.charAt(left)-'a']--;
                left++;
            } maxLen = Math.max(maxLen, right-left+1);
            right++;
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
    }
}
