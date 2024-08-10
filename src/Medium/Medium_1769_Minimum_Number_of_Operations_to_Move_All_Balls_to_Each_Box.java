// 1769. Minimum Number of Operations to Move All Balls to Each Box
package Medium;
import java.util.Arrays;

public class Medium_1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {
    public static int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] answer = new int[length];
        for (int i=0; i<length; i++)
            for (int j=0; j<length; j++)
                if (boxes.charAt(j) == '1' && i != j)
                    answer[i] += Math.abs(i-j);
        return answer;
    }
    public static int[] minOperationsBetter(String boxes) {
        int len = boxes.length();
        int[] result = new int[len];
        int balls = 0, ops = 0;
        // Balls on the left <- result[i] -> balls on the right
        for (int i=0; i<len; i++) {
            result[i] += ops;
            // Count the number of balls in boxes[i]
            balls += boxes.charAt(i)-'0';
            // Operations required to move the balls to i-th index
            ops += balls;
        }
        balls = ops = 0;
        for (int i=len-1; i>=0; i--) {
            result[i] += ops;
            balls += boxes.charAt(i)-'0';
            ops += balls;
        } return result;
    }
    public static int[] minOperationsOptimal(String boxes) {
        int len = boxes.length();
        // Operations required to move the balls from the left
        int[] left = new int[len];
        int count = boxes.charAt(0)-'0';
        for (int i=1; i<len; i++) {
            left[i] = left[i-1] + count;
            count += boxes.charAt(i)-'0';
        }
        // Operations required to move the balls from the right
        int[] right = new int[len];
        count = boxes.charAt(len-1)-'0';
        for (int i=len-2; i>=0; i--) {
            right[i] = right[i+1] + count;
            count += boxes.charAt(i)-'0';
        }
        int[] answer = new int[len];
        for (int i=0; i<len; i++)
            answer[i] = left[i] + right[i];
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
        System.out.println(Arrays.toString(minOperationsBetter("110")));
        System.out.println(Arrays.toString(minOperationsBetter("001011")));
    }
}
