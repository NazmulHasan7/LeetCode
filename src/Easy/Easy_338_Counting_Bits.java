// 338. Counting Bits
package Easy;
import java.util.Arrays;

public class Easy_338_Counting_Bits {
    public static int[] countBits(int n) {
        int[] bits = new int[n+1];
        for (int i=0; i<=n; i++)
            bits[i] = Integer.bitCount(i);
        return bits;
    }
    public static int[] countBitsTest(int n) {
        int [] bits = new int[n+1];
        int temp;
        bits[0] = 0;
        for (int i=1; i<=n; i++) {
            int count = 0;
            temp = i;
            while (temp != 0) {
                count++;
                temp = temp & (temp - 1);
            } bits[i] = count;
        }
        return bits;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBitsTest(2)));
        System.out.println(Arrays.toString(countBitsTest(5)));
    }
}
