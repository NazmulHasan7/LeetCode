// 796. Rotate String
package Easy;

public class Easy_796_Rotate_String {
    // s ==> abcde + abcde = ab[cdeab]cde goal ==> cdeab
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }
}
