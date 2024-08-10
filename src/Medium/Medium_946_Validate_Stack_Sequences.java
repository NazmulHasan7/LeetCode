// 946. Validate Stack Sequences
package Medium;
import java.util.Stack;

public class Medium_946_Validate_Stack_Sequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        } return stack.isEmpty();
    }
    public static boolean validateStackSequencesBetter(int[] pushed, int[] popped) {
        int pushIdx = 0, popIdx = 0;
        for (int x : pushed) {
            pushed[pushIdx++] = x;
            while (pushIdx != 0 && popped[popIdx] == pushed[pushIdx-1]) {
                popIdx++;
                pushIdx--;
            }
        } return pushIdx == 0;
    }
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
    }
}
