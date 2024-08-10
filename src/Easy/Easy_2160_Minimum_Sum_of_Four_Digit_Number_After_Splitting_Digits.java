// 2160. Minimum Sum of Four Digit Number After Splitting Digits
package Easy;
import java.util.Arrays;

public class Easy_2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {
    public static int minimumSum(int num) {
        int[] nrr = new int[4];
        int index = 0;
        while (num != 0) {
            nrr[index++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nrr);
        return (nrr[0]*10 + nrr[3]) + (nrr[1]*10 + nrr[2]);
    }
    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
    }
}
