// 1347. Minimum Number of Steps to Make Two Strings Anagram
package Medium;

public class Medium_1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
    public static int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        for (char c : s.toCharArray()) sFreq[c-'a']++;

        int[] tFreq = new int[26];
        for (char c : t.toCharArray()) tFreq[c-'a']++;

        int steps = 0;
        for (int i=0; i<sFreq.length; i++)
            if (sFreq[i] > tFreq[i])
                steps += sFreq[i] - tFreq[i];
        return steps;
    }
    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
    }
}
