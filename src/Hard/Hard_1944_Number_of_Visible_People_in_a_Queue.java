// 1944. Number of Visible People in a Queue
package Hard;
import java.util.Arrays;

public class Hard_1944_Number_of_Visible_People_in_a_Queue {
    public static int[] canSeePersonsCount(int[] heights) {
        int[] stack = new int[heights.length];
        int stackPtr = -1;
        int[] answer = new int[heights.length];

        for (int i=heights.length-1; i>=0; i--) {
            int visible = 0;
            while (stackPtr >- 1 && heights[i] > stack[stackPtr]) {
                visible++;
                stackPtr--;
            }
            // If the stack is not empty, then the person with current height
            // Can definitely see the person at the top of the stack
            if (stackPtr >- 1) visible++;
            answer[i] = visible;
            stack[++stackPtr] = heights[i];
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[] {10,6,8,5,11,9})));
        System.out.println(Arrays.toString(canSeePersonsCount(new int[] {5,1,2,3,10})));
    }
}
