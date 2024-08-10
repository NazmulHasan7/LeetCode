// 2595. Number of Even and Odd Bits
package Easy;
import java.util.Arrays;

public class Easy_2595_Number_of_Even_and_Odd_Bits {
    public static int[] evenOddBit(int n) {
        int[] bits = new int[2];
        int i = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) bits[0]++;
                else bits[1]++;
            } i++;
            n >>= 1;
        }
        return bits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(17)));
        System.out.println(Arrays.toString(evenOddBit(2)));
    }
}
