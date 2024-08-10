// 225. Implement Stack using Queues
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_225_Implement_Stack_using_Queues {
    static class MyStack {
        Queue<Integer> queue;
        Queue<Integer> tempQueue;
        int peek;
        public MyStack() {
            queue = new LinkedList<>();
            tempQueue = new LinkedList<>();
        }
        public void push(int x) {
            peek = x;
            tempQueue.add(x);

            while (!queue.isEmpty())
                tempQueue.add(queue.remove());
            while (!tempQueue.isEmpty())
                queue.add(tempQueue.remove());
        }
        public int pop() { return queue.remove(); }
        public int top() { return peek; }
        public boolean empty() { return queue.isEmpty(); }
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
