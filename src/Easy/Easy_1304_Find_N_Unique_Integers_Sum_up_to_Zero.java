// 1304. Find N Unique Integers Sum up to Zero
package Easy;
import java.util.Arrays;

public class Easy_1304_Find_N_Unique_Integers_Sum_up_to_Zero {
    public static int[] sumZero(int n) {
        int start = (n/2) * -1;
        int end = n/2;
        int[] arr = new int[n];

        int i = 0;
        while (start < 0 && end > 0) {
            arr[i++] = start++;
            arr[i++] = end--;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(4)));
        System.out.println(Arrays.toString(sumZero(1)));
    }
}
