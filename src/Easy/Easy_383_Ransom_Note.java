// 383. Ransom Note
package Easy;

public class Easy_383_Ransom_Note {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c : magazine.toCharArray())
            freq[c-'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (freq[c-'a'] <= 0)
                return false;
            else freq[c-'a']--;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
