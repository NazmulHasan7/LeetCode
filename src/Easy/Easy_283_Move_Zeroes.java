// 283. Move Zeroes
package Easy;
import java.util.Arrays;

public class Easy_283_Move_Zeroes {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i=0, nzIndex=0; i<n; i++) {
            if (nums[i] != 0) {
                if (nzIndex < i) {
                    nums[i] = nums[i] ^ nums[nzIndex];
                    nums[nzIndex] = nums[nzIndex] ^ nums[i];
                    nums[i] = nums[i] ^ nums[nzIndex];
                }
                nzIndex++;
            }
        }
    }
    public static void moveZeroesBetter(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j=0; j<n; j++)
            if (nums[j] != 0)
                nums[i++] = nums[j];
        Arrays.fill(nums, i, n, 0);
    }
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        moveZeroesBetter(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {0};
        moveZeroesBetter(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
