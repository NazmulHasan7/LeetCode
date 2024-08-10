// 1249. Minimum Remove to Make Valid Parentheses
package Medium;
import java.util.Stack;

public class Medium_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    public static String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') {
                if (open == 0) continue;
                open--;
            } sb.append(c);
        }
        // For rest of the opening parenthesis
        StringBuilder result = new StringBuilder();
        for (int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) continue;
            result.append(sb.charAt(i));
        } return result.reverse().toString();
    }
    public static String minRemoveToMakeValidStack(String s) {
        int open = 0, close = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') close++;
            if (close > open) close--;
            else stack.push(c);
        }
        // For rest of the opening parenthesis
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            if (open > close && stack.peek() == '(') {
                stack.pop();
                open--;
            } else result.append(stack.pop());
        } return result.reverse().toString();
    }
    public static String minRemoveToMakeValidBetter(String s) {
        char[] crr = s.toCharArray();
        int open = 0;
        for (int i=0; i<crr.length; i++) {
            if (crr[i] == '(') open++;
            else if (crr[i] == ')') {
                // Mark extra closing parenthesis
                if (open == 0) crr[i] = '*';
                else open--;
            }
        }
        // Marks extra opening parenthesis
        for (int i=crr.length-1; i>=0; i--)
            if (crr[i] == '(' && open-- > 0) crr[i] = '*';

        // Update the Character Array
        int ptr = 0;
        for (int i=0; i<crr.length; i++)
            if (crr[i] != '*') crr[ptr++] = crr[i];
        return String.valueOf(crr, 0, ptr);
    }
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValidStack("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValidStack("a)b(c)d"));
        System.out.println(minRemoveToMakeValidStack("))(("));
        System.out.println(minRemoveToMakeValidStack("))))"));
        System.out.println(minRemoveToMakeValidStack("(((("));
    }
}
