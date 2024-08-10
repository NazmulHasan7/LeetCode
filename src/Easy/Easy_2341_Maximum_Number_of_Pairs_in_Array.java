// 2341. Maximum Number of Pairs in Array
package Easy;
import java.util.Arrays;

public class Easy_2341_Maximum_Number_of_Pairs_in_Array {
    public static int[] numberOfPairs(int[] nums) {
        int pairs = 0, leftovers = 0;
        int[] arr = new int[101];
        for (int num : nums)
            arr[num]++;

        for (int i=0; i<arr.length; i++) {
            pairs += arr[i] / 2;
            leftovers += arr[i] % 2;
        } return new int[] {pairs, leftovers};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[] {1,3,2,1,3,2,2})));
        System.out.println(Arrays.toString(numberOfPairs(new int[] {1,1})));
        System.out.println(Arrays.toString(numberOfPairs(new int[] {0})));
    }
}
