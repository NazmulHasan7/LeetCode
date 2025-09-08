// 1317. Convert Integer to the Sum of Two No-Zero Integers
package Easy;
import java.util.Arrays;

public class Easy_1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {
    public static int[] getNoZeroIntegers(int n) {
        for (int a=1; a<n; a++) {
            int b = n - a;
            if (!String.valueOf(a).contains("0") &&
                    (!String.valueOf(b).contains("0"))
            ) return new int[]{a,b};
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(getNoZeroIntegers(11)));
    }
}
