// 2486. Append Characters to String to Make Subsequence
package Medium;

public class Medium_2486_Append_Characters_to_String_to_Make_Subsequence {
    public static int appendCharacters(String s, String t) {
        int tPtr = 0, tLength = t.length();
        for (char c : s.toCharArray()) {
            if (c == t.charAt(tPtr)) tPtr++;
            if (tPtr == tLength) break;
        } return tLength - tPtr;
    }
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "a"));

    }
}