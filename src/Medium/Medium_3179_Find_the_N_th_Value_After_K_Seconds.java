// 3179. Find the N-th Value After K Seconds
package Medium;
import java.util.Arrays;

public class Medium_3179_Find_the_N_th_Value_After_K_Seconds {
    // Draw the patterns ->
    // 1 1 1 1 -> 1 2 3 4 -> 1 3 6 10 -> 1 4 10 20 -> .......
    public static int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        while (k-- > 0) {
            for (int i=1; i<n; i++)
                arr[i] = (int) ((arr[i] + arr[i-1]) % 1000000007);
        }
        return arr[n-1];
    }
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(4,5));
        System.out.println(valueAfterKSeconds(5,3));
    }
}
