// 2351. First Letter to Appear Twice
package Easy;

public class Easy_2351_First_Letter_to_Appear_Twice {
    public static char repeatedCharacter(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (freq[c-'a'] == 1) return c;
            else freq[c-'a']++;
        } return ' ';
    }
    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
        System.out.println(repeatedCharacter("abcdd"));
    }
}
