// 150. Evaluate Reverse Polish Notation
package Medium;
import java.util.Stack;

public class Medium_150_Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        } return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
