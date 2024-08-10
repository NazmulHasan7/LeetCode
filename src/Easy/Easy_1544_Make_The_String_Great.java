// 1544. Make The String Great
package Easy;
import java.util.Stack;

public class Easy_1544_Make_The_String_Great {
    public static String makeGoodBetter(String s) {
        StringBuilder str = new StringBuilder();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (length > 0 && Math.abs(c - str.charAt(length-1)) == 32) {
                str.deleteCharAt(length-1);
                length--;
            } else {
                str.append(c);
                length++;
            }
        } return str.toString();
    }
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && Math.abs(stack.peek() - c) == 32)
                stack.pop();
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
        System.out.println(makeGoodBetter("leEeetcode"));
        System.out.println(makeGoodBetter("abBAcC"));
        System.out.println(makeGoodBetter("s"));
    }
}
