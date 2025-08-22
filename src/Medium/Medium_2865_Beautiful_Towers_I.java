// 2865. Beautiful Towers I
package Medium;
import java.util.Stack;

public class Medium_2865_Beautiful_Towers_I {
    public static long maximumSumOfHeights(int[] heights) {
        long answer = 0;
        int n = heights.length;

        for (int i=0; i<n; i++) {
            int peak = heights[i];
            long sum = peak;
            int prev = peak;

            for (int j=i-1; j>=0; j--) {
                prev = Math.min(heights[j], prev);
                sum += prev;
            }
            prev = peak;
            for (int k=i+1; k<n; k++){
                prev = Math.min(heights[k], prev);
                sum += prev;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static long maximumSumOfHeightsOpt(int[] heights) {
        int n = heights.length;
        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i])
                stack.pop(); // before peak left values should be less or equal

            int prev = stack.isEmpty() ? -1 : stack.peek();
            left[i] = (prev == -1 ? 0 : left[prev]) + (long) (i-prev) * heights[i];
            stack.push(i);
        }

        stack.clear();
        long[] right = new long[n];

        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i])
                stack.pop(); // after peak right values should be less or equal

            int next = stack.isEmpty() ? n : stack.peek();
            right[i] = (next != n ? right[next] : 0) + (long) (next-i) * heights[i];
            stack.push(i);
        }

        long answer = 0;
        for (int i=0; i<n; i++)
            answer = Math.max(answer, left[i] + right[i] - heights[i]);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumSumOfHeights(new int[]{5,3,4,1,1}));
        System.out.println(maximumSumOfHeights(new int[]{6,5,3,9,2,7}));
        System.out.println(maximumSumOfHeights(new int[]{3,2,5,5,2,3}));
        System.out.println(maximumSumOfHeightsOpt(new int[]{5,3,4,1,1}));
        System.out.println(maximumSumOfHeightsOpt(new int[]{6,5,3,9,2,7}));
        System.out.println(maximumSumOfHeightsOpt(new int[]{3,2,5,5,2,3}));
    }
}
