// 2716. Minimize String Length
package Easy;

public class Easy_2716_Minimize_String_Length {
    public static int minimizedStringLength(String s) {
        int length = 0;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (freq[c-'a'] == 0)
                freq[c-'a']++;
            else length++;
        } return s.length() - length;
    }
    public static void main(String[] args) {
        System.out.println(minimizedStringLength("aaabc"));
        System.out.println(minimizedStringLength("cbbd"));
        System.out.println(minimizedStringLength("dddaaa"));
    }
}
