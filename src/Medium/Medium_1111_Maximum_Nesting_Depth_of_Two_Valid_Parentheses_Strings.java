// 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
package Medium;
import java.util.Arrays;

public class Medium_1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {
    public static int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int idx = 0;

        /* Confusing Question -> Given a VPS seq, split it into two disjoint subsequences A and B,
        such that A and B are VPS (and A.length + B.length = seq.length)

        Stack<Character> stack = new Stack<>();

        for (char c : seq.toCharArray()) {
            if (c == '(') {
                answer[idx++] = stack.size() % 2;
                stack.push(c);
            } else {
                // Since it is a valid parenthesis staring we ) means there is ( in the stack
                stack.pop();
                answer[idx++] = stack.size() % 2;
            }
        }
        return answer; */

        int A = 0, B = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                // Opening parenthesis -> check the depth of each sequence
                if (A <= B) {
                    answer[idx] = 0;
                    A++;
                } else {
                    answer[idx] = 1;
                    B++;
                }
            } else {
                if (A >= B) {
                    answer[idx] = 0;
                    A--;
                } else {
                    answer[idx] = 1;
                    B--;
                }
            }
            idx++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("((()))")));
    }
}
