// 155. Min Stack
package Medium;
import java.util.Stack;

public class Medium_155_Min_Stack {
    static class Pair {
        int value;
        int min;
        public Pair(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    static class MinStack {
        Stack<Pair> stack;
        int min;
        public MinStack() {
            stack = new Stack<>();
        }
        public void push(int val) {
            if (stack.isEmpty()) min = val;
            else min = Math.min(val, min);
            stack.push(new Pair(val, min));
        }
        public void pop() { stack.pop(); }
        public int top() { return stack.peek().value; }
        public int getMin() { return stack.peek().min; }
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
