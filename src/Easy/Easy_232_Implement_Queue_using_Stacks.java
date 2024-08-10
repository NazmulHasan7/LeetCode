// 232. Implement Queue using Stacks
package Easy;
import java.util.Stack;

public class Easy_232_Implement_Queue_using_Stacks {
    static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> tempStack;
        int peek;
        public MyQueue() {
            stack = new Stack<>();
            tempStack = new Stack<>();
        }
        public void push(int x) {
            if (stack.isEmpty()) peek = x;
            stack.push(x);
        }
        public int pop() {
            while (!stack.isEmpty())
                tempStack.push(stack.pop());

            int top = tempStack.pop();
            if (!tempStack.isEmpty())
                peek = tempStack.peek();

            while (!tempStack.isEmpty())
                stack.push(tempStack.pop());
            return top;
        }
        public int peek() { return peek; }
        public boolean empty() { return stack.isEmpty(); }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
