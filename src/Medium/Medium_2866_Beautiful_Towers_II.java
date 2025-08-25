// 2866. Beautiful Towers II
package Medium;
import java.util.List;
import java.util.Stack;

public class Medium_2866_Beautiful_Towers_II {
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i))
                stack.pop(); // before peak left values should be less or equal

            int prev = stack.isEmpty() ? -1 : stack.peek();
            left[i] = (prev == -1 ? 0 : left[prev]) + (long) (i-prev) * maxHeights.get(i);
            stack.push(i);
        }

        stack.clear();
        long[] right = new long[n];

        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i))
                stack.pop(); // after peak right values should be less or equal

            int next = stack.isEmpty() ? n : stack.peek();
            right[i] = (next != n ? right[next] : 0) + (long) (next-i) * maxHeights.get(i);
            stack.push(i);
        }

        long answer = 0;
        for (int i=0; i<n; i++)
            answer = Math.max(answer, left[i] + right[i] - maxHeights.get(i));

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumSumOfHeights(List.of(5,3,4,1,1)));
        System.out.println(maximumSumOfHeights(List.of(6,5,3,9,2,7)));
        System.out.println(maximumSumOfHeights(List.of(3,2,5,5,2,3)));
    }
}
