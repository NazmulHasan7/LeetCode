// 39. Daily Temperatures
package Medium;
import java.util.Arrays;
import java.util.Stack;

public class Medium_39_Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i=temperatures.length-1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
                stack.pop();

            answer[i] = !stack.isEmpty() ? stack.peek()-i : 0;
            stack.push(i);
        } return answer;
    }
    public static int[] dailyTemperaturesBetter(int[] temperatures) {
        int len = temperatures.length;
        int[] stack = new int[len];
        int[] answer = new int[len];
        int stackPtr = -1;

        for (int i=len-1; i>=0; i--) {
            while (stackPtr>=0 && temperatures[stack[stackPtr]]<=temperatures[i])
                stackPtr--;

            answer[i] = stackPtr>-1 ? stack[stackPtr]-i : 0;
            stack[++stackPtr] = i;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(dailyTemperaturesBetter(new int[] {73,74,75,71,69,72,76,73})));
    }
}
