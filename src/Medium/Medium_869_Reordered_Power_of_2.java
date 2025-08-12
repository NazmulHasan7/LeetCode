// 869. Reordered Power of 2
package Medium;
import java.util.Arrays;

public class Medium_869_Reordered_Power_of_2 {
    private static int[] getCountArr(int n) {
        int[] arr = new int[10];
        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }
        return arr;
    }
    public static boolean reorderedPowerOf2(int n) {
        int[] numArr = getCountArr(n);
        long powerOfTwo = 1;

        while (powerOfTwo <= Integer.MAX_VALUE) {
            if (Arrays.equals(numArr, getCountArr((int)powerOfTwo)))
                return true;
            powerOfTwo <<= 1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
    }
}
