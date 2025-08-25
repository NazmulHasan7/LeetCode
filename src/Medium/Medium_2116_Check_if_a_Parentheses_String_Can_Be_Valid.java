// 2116. Check if a Parentheses String Can Be Valid
package Medium;
import java.util.Stack;

public class Medium_2116_Check_if_a_Parentheses_String_Can_Be_Valid {
    public static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> freeToChoose = new Stack<>();

        for (int i=0; i<n; i++) {
            if (locked.charAt(i) == '0') {
                freeToChoose.push(i);
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) stack.pop();
                else if (!freeToChoose.isEmpty()) freeToChoose.pop();
                else return false;
            }
        }
        while (!stack.isEmpty() && !freeToChoose.isEmpty() && stack.peek() < freeToChoose.peek()) {
            stack.pop();
            freeToChoose.pop();
        }
        return stack.isEmpty() && freeToChoose.size() % 2 == 0;
    }
    // optimized approach
    public static boolean canBeValidOpt(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        int freeToUse = 0;
        int open = 0;

        // check from left to right
        for (int i=0; i<n; i++) {
            if (locked.charAt(i) == '0') {
                freeToUse++;
            } else {
                if (s.charAt(i) == '(') open++;
                else open--;
            }
            // if at any position, there is an excess (, it is invalid
            if (open + freeToUse < 0) return false;
        }

        freeToUse = 0;
        int close = 0;
        for (int i=n-1; i>=0; i--) {
            if (locked.charAt(i) == '0') {
                freeToUse++;
            } else {
                if (s.charAt(i) == ')') close++;
                else close--; // ()()( -> close < 0
            }
            // if at any position, there is an excess ), it is invalid
            if (close + freeToUse < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canBeValid("))()))", "010100"));
        System.out.println(canBeValid("()()", "0000"));
        System.out.println(canBeValid(")", "0"));
        System.out.println(canBeValid("(((())(((())", "111111010111"));
    }
}
