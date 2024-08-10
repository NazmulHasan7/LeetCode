// 2375. Construct Smallest Number From DI String
package Medium;
import java.util.Stack;

public class Medium_2375_Construct_Smallest_Number_From_DI_String {
    public static String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = pattern.length();

        int current = 1;
        for (int i=0; i<=n; i++) {
            // Keep adding to the stack until encountered I
            stack.add(current++);
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty())
                    answer.append(stack.pop());
            }
        } return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }
}
