// 3174. Clear Digits
package Easy;
import java.util.Stack;

public class Easy_3174_Clear_Digits {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
    public static String clearDigitsOpt(String s) {
        char[] stack = new char[s.length()];
        int idx = -1;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                stack[++idx] = c;
            else if (idx != -1)
                idx--;
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i <= idx)
            sb.append(stack[i++]);

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }
}
