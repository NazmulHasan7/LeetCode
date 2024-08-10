// 844. Backspace String Compare
package Easy;
import java.util.Stack;

public class Easy_844_Backspace_String_Compare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#' && !sStack.isEmpty()) sStack.pop();
            else if (c != '#') sStack.push(c);
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && !tStack.isEmpty()) tStack.pop();
            else if (c != '#') tStack.push(c);
        } return sStack.equals(tStack);
    }
    public static boolean backspaceCompareBetter(String s, String t) {
        int si = s.length()-1;
        int ti = t.length()-1;
        int sHashCount = 0, tHashCont = 0;
        while (si >= 0 || ti >= 0) {
            while (si >= 0) {
                if (s.charAt(si) == '#') sHashCount++;
                else if (sHashCount > 0) sHashCount--;
                else break;
                si--;
            }
            while (ti >= 0) {
                if (t.charAt(ti) == '#') tHashCont++;
                else if (tHashCont > 0) tHashCont--;
                else break;
                ti--;
            }
            if (si >= 0 && ti >= 0 && s.charAt(si) != t.charAt(ti)) return false;
            if (si >= 0 != ti >= 0) return false;
            si--;
            ti--;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare( "a#c", "b"));
        System.out.println(backspaceCompareBetter("ab#c", "ad#c"));
        System.out.println(backspaceCompareBetter("ab##", "c#d#"));
        System.out.println(backspaceCompareBetter( "a#c", "b"));
    }
}
