// 922. Sort Array By Parity II
package Easy;
import java.util.Arrays;

public class Easy_922_Sort_Array_By_Parity_II {
    public static int[] sortArrayByParityII(int[] nums) {
        int[] answer = new int[nums.length];
        int evenIndex = 0, oddIndex = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                answer[evenIndex] = num;
                evenIndex += 2;
            } else {
                answer[oddIndex] = num;
                oddIndex += 2;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[] {4,2,5,7})));
        System.out.println(Arrays.toString(sortArrayByParityII(new int[] {2,3})));
    }
}
