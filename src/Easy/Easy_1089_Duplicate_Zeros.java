// 1089. Duplicate Zeros
package Easy;
import java.util.Arrays;

public class Easy_1089_Duplicate_Zeros {
    public static void duplicateZeros(int[] arr) {
        int length = arr.length;
        for (int i=0; i<length; i++) {
            if (arr[i] == 0 && i+1 < length) {
                for (int j=length-1; j>=i+1; j--)
                    arr[j] = arr[j-1];
                arr[i+1] = 0;
                i++;
            }
        }
    }
    public static void duplicateZerosBetter(int[] arr) {
        int length = arr.length;
        int[] answer = new int[length];

        int idx = 0;
        for (int i=0; i<length && idx<length; i++) {
            if (arr[i] == 0) idx += 2;
            else answer[idx++] = arr[i];
        }
        for (idx=0; idx<length; idx++)
            arr[idx] = answer[idx];
    }
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZerosBetter(arr);
        System.out.println(Arrays.toString(arr));
    }
}
