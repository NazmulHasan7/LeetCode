// 1470. Shuffle the Array
package Easy;
import java.util.Arrays;

public class Easy_1470_Shuffle_the_Array {
    public static int[] shuffle(int[] nums, int n) {
        int[] newArray = new int[2 * n];
        for (int i=0, k=0; k<n; i++, k++) {
            newArray[i++] = nums[k];
            newArray[i] = nums[k+n];
        }
        return newArray;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[] {2,5,1,3,4,7}, 3)));
        System.out.println(Arrays.toString(shuffle(new int[] {1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(shuffle(new int[] {1,1,2,2}, 2)));
    }
}
