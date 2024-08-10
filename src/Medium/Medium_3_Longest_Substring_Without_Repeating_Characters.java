// 3. Longest Substring Without Repeating Characters
package Medium;
import java.util.HashMap;

public class Medium_3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, len = s.length();
        int maxLen = 0;

        while (right < len) {
            char c = s.charAt(right);
            // If there is a previous occurrence of this character in current sub-array
            // then update the left pointer
            if (map.containsKey(c) && map.get(c) >= left)
                left = map.get(c) + 1;
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        } return maxLen;
    }
    public int lengthOfLongestSubstringBetter(String s) {
        int left = 0, right = 0, len = s.length();
        int maxLen = 0;
        while(right < len) {
            char c = s.charAt(right);
            for(int i=left; i<right; i++){
                if(s.charAt(i) == c){
                    left = i+1;
                    break;
                }
            } maxLen = Math.max(maxLen, right-left+1);
            right++;
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
