// 1190. Reverse Substrings Between Each Pair of Parentheses
package Medium;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Medium_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                Queue<Character> queue = new LinkedList<>();
                while (stack.peek() != '(')
                    // Pop and store in the queue in reverse order
                    queue.add(stack.pop());
                stack.pop();
                // populate the reversed chars in stack again
                while (!queue.isEmpty())
                    stack.push(queue.remove());
            } else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
    public static String reverseParenthesesBetter(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] crr = s.toCharArray();

        for (int i=0; i<s.length(); i++) {
            // Store open index
            if (crr[i] == '(')
                stack.push(i);
            else if (crr[i] == ')')
                reverse(crr, stack.pop()+1, i-1);
        }
        StringBuilder answer = new StringBuilder();
        for (char c : crr)
            if (c != '(' && c !=')') answer.append(c);
        return answer.toString();
    }
    public static void reverse(char[] srr, int start, int end) {
        char temp;
        while (start < end) {
            temp = srr[start];
            srr[start++] = srr[end];
            srr[end--] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParenthesesBetter("(abcd)"));
        System.out.println(reverseParenthesesBetter("(u(love)i)"));
        System.out.println(reverseParenthesesBetter("(ed(et(oc))el)"));
    }
}
