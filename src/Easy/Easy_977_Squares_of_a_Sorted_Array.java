// 977. Squares of a Sorted Array
package Easy;
import java.util.Arrays;

public class Easy_977_Squares_of_a_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        int start = 0, end = nums.length-1;
        int[] answer = new int[nums.length];

        for (int i=nums.length-1; i>=0; i--) {
            if (Math.abs(nums[start]) < Math.abs(nums[end]))
                answer[i] = nums[end] * nums[end--];
            else answer[i] = nums[start] * nums[start++];
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] {-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[] {-7,-3,2,3,11})));
    }
}
