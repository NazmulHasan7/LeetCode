// 66. Plus One
package Easy;
import java.util.Arrays;

public class Easy_66_Plus_One {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i=n-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } digits[i] = 0;
        }
        int[] newDigits = new int[n+1];
        newDigits[0] = 1;
        return newDigits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[] {4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[] {9})));
        System.out.println(Arrays.toString(plusOne(new int[] {0, 0, 0, 9})));
    }
}
