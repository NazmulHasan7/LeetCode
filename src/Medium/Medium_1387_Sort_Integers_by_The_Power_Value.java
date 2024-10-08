// 1387. Sort Integers by The Power Value
package Medium;
import java.util.Arrays;

public class Medium_1387_Sort_Integers_by_The_Power_Value {
    public static int getKth(int lo, int hi, int k) {
        // store as -> {number, count}
        int[][] arr = new int[hi-lo+1][2];
        for (int i=lo; i<=hi; i++) {
            int count = 0;
            int number = i;
            while (number != 1) {
                if (number % 2 == 0)
                    number /= 2;
                else number = (3 * number) + 1;
                count++;
            }
            arr[i-lo] = new int[]{i, count};
        }
        // sort based on the count
        Arrays.sort(arr, (a, b) -> a[1]-b[1]);
        return arr[k-1][0];
    }
    public static void main(String[] args) {
        System.out.println(getKth(12,15,2));
        System.out.println(getKth(7,11,4));
    }
}
