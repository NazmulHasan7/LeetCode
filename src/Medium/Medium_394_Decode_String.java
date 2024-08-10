// 394. Decode String
package Medium;
import java.util.Stack;

public class Medium_394_Decode_String {
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                // System.out.println(numStack);
                // System.out.println(strStack);
                // System.out.println(sb);
                int top = numStack.pop();
                StringBuilder topStr = strStack.pop();
                while (top-- > 0)
                    topStr.append(sb);
                if (!topStr.isEmpty()) sb = topStr;
            } else {
                sb.append(c);
            }
        } return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("[a2[c]]"));
        System.out.println(decodeString("3[abc2[def]]"));
    }
}
