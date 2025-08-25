// 636. Exclusive Time of Functions
package Medium;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Medium_636_Exclusive_Time_of_Functions {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = -1;

        for (String log : logs) {
            String[] values = log.split(":");
            int id = Integer.parseInt(values[0]);
            int curTime = Integer.parseInt(values[2]);

            if (values[1].equals("start")) {
                if (!stack.isEmpty()) // update the duration for current running function
                    answer[stack.peek()] += curTime - prevTime - 1;
                stack.push(id); // call the new function
            } else { // function execution ends
                answer[stack.peek()] += curTime - prevTime + 1;
                stack.pop();
            }
            prevTime = curTime;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
        System.out.println(Arrays.toString(exclusiveTime(1, List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"))));
        System.out.println(Arrays.toString(exclusiveTime(2, List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"))));
    }
}
