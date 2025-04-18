// 2186. Minimum Number of Steps to Make Two Strings Anagram II
package Medium;

public class Medium_2186_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram_II {
    public static int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for (char c : s.toCharArray())
            sFreq[c-'a']++;

        for (char c : t.toCharArray())
            tFreq[c-'a']++;

        int answer = 0;
        for (int i=0; i<26; i++)
            answer += Math.abs(sFreq[i] - tFreq[i]);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minSteps("leetcode", "coats"));
        System.out.println(minSteps("night", "thing"));
    }
}
