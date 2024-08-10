// 227. Basic Calculator II
package Medium;
import java.util.Stack;

public class Medium_227_Basic_Calculator_II {
    public static int calculate(String s) {
        int length = s.length();
        int top = 0, number = 0, answer = 0;
        char operator = '+';

        for (int i=0; i<length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                number = number * 10 + c - '0';
            if (c=='+' || c=='-'|| c=='*' || c=='/' || i==length-1) {
                switch (operator) {
                    case '+' -> {
                        answer += top;
                        top = number;
                    }
                    case '-' -> {
                        answer += top;
                        top = -number;
                    }
                    case '*' -> top = top * number;
                    case '/' -> top = top / number;
                }
                number = 0;
                operator = c;
            }
        } return answer + top;
    }
    public static int calculateStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int number = 0;
        char operator = '+';

        for (int i=0; i<length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                number = number * 10 + c - '0';
            // If (not else if) condition is to handle the last number
            if (!Character.isDigit(c) && c != ' ' || i == length-1) {
                switch (operator) {
                    case '+' -> stack.push(number);
                    case '-' -> stack.push(-number);
                    case '*' -> stack.push(stack.pop() * number);
                    case '/' -> stack.push(stack.pop() / number);
                }
                number = 0;
                operator = c;
            }
        }
        int answer = 0;
        while (!stack.isEmpty())
            answer += stack.pop();
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate("3+5 / 2"));
    }
}
