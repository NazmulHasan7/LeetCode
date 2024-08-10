// 1297. Maximum Number of Occurrences of a Substring
package Medium;
import java.util.HashMap;
import java.util.Map;

public class Medium_1297_Maximum_Number_of_Occurrences_of_a_Substring {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> occurrences = new HashMap<>();
        int left = 0, right = 0, len = s.length();
        int[] freqCount = new int[26];

        int uniqueCount = 0;
        while (right < len) {
            char rightChar = s.charAt(right);
            freqCount[rightChar-'a']++;
            if (freqCount[rightChar-'a'] == 1)
                uniqueCount++;

            while ((right-left+1) >= minSize && (right-left+1) <= maxSize) {
                if (uniqueCount <= maxLetters) {
                    String subStr = s.substring(left,right+1);
                    occurrences.put(subStr, occurrences.getOrDefault(subStr,0)+1);
                }
                char leftChar = s.charAt(left);
                freqCount[leftChar-'a']--;
                if (freqCount[leftChar-'a'] == 0)
                    uniqueCount--;
                left++;
            } right++;
        }
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : occurrences.entrySet())
            maxCount = Math.max(maxCount, entry.getValue());
        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab",2,3,4));
        System.out.println(maxFreq("aaaa",1,3,3));
    }
}
