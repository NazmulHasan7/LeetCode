// 1929. Concatenation of Array
package Easy;
import java.util.Arrays;

public class Easy_1929_Concatenation_of_Array {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i=0; i<n; i++)
            arr[n+i] = arr[i] = nums[i];
        return arr;
    }
    public static int[] getConcatenationBetter(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        System.arraycopy(nums, 0, arr, 0, n);
        System.arraycopy(nums, 0, arr, n, n);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int[] newArr = getConcatenationBetter(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
