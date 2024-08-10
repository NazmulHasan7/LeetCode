// 503. Next Greater Element II
package Medium;
import java.util.Arrays;

public class Medium_503_Next_Greater_Element_II {
    // Leetcode 496 : Next Greater Element I
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int stackPtr = -1;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // For the circular array property, need to traverse twice
        for (int t=0; t<2; t++) {
            for (int i=0; i<n; i++) {
                while (stackPtr >= 0 && nums[i] > nums[stack[stackPtr]])
                    answer[stack[stackPtr--]] = nums[i];

                if (t == 0) stack[++stackPtr] = i;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1,2,1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1,2,3,4,3})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {5,4,3,2,1})));
    }
}
