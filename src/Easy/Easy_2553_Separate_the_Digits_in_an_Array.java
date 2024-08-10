// 2553. Separate the Digits in an Array
package Easy;
import java.util.Arrays;

public class Easy_2553_Separate_the_Digits_in_an_Array {
    public static int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num);
        String numbers = sb.toString();

        int[] digits = new int[numbers.length()];
        for (int i=0; i<digits.length; i++)
            digits[i] = numbers.charAt(i) - '0';

        return digits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[] {13,25,83,77})));
        System.out.println(Arrays.toString(separateDigits(new int[] {7,1,3,9})));
    }
}
