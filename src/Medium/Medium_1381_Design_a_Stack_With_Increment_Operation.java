// 1381. Design a Stack With Increment Operation
package Medium;

public class Medium_1381_Design_a_Stack_With_Increment_Operation {
    static class CustomStack {
        int maxSize;
        int[] stack;
        int stackPtr;
        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            stackPtr = -1;
            stack = new int[maxSize];
        }
        public void push(int x) {
            if (stackPtr < maxSize-1)
                stack[++stackPtr] = x;
        }
        public int pop() {
            if (stackPtr >= 0)
                return stack[stackPtr--];
            else return -1;
        }
        public void increment(int k, int val) {
            for (int i=0; i<k && i<=stackPtr; i++)
                stack[i] += val;
        }
    }
    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3);
        stk.push(1);
        stk.push(2);
        System.out.println(stk.pop());
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.increment(5, 100);
        stk.increment(2, 100);
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
