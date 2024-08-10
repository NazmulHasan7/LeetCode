// 20 Valid Parentheses
package Easy;
import java.util.Stack;

public class Easy_20_Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    char popped_item = stack.pop();
                    if (c == ')' && popped_item != '(')
                        return false;
                    else if (c == '}' && popped_item != '{')
                        return false;
                    else if (c == ']' && popped_item != '[')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValidBetterSolution(String s) {
        char[] arr = new char[s.length()];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                arr[++i] = c;
            else if (i >= 0 && (arr[i]=='(' && c == ')' || arr[i]=='{' && c == '}' || arr[i]=='[' && c == ']'))
                i--;
            else
                return false;
        }
        return i == -1;
    }
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("["));
    }
}
