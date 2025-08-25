// 3561. Resulting String After Adjacent Removals
package Medium;
import java.util.Stack;

public class Medium_3561_Resulting_String_After_Adjacent_Removals {
    public static String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            char next = (char)('a' + (c-'a'+1) % 26);
            char prev = (char)('a' + (26+c-'a'-1) % 26);
            if (!stack.isEmpty() && (stack.peek() == next || stack.peek() == prev))
                stack.pop();
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
    public static String resultingStringOpt(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (top >= 0) {
                int diff = Math.abs(c - stack[top]);
                if (diff == 1 || diff == 25) {
                    top--;
                    continue;
                }
            } stack[++top] = c;
        }
        return new String(stack, 0, top+1);
    }
    public static void main(String[] args) {
        System.out.println(resultingStringOpt("abc"));
        System.out.println(resultingStringOpt("zadb"));
    }
}
