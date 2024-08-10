// 189. Rotate Array
package Medium;
import java.util.Arrays;

public class Medium_189_Rotate_Array {
    public static void rotate(int[] nums, int k) {
        int[] answer = new int[nums.length];
        int n = nums.length;
        k = k % n;
        for (int i=0; i<n; i++)
            // System.out.println("i -> " + i + " (i+k)%n -> " + ((i+k)%n));
            answer[(i+k)%n] = nums[i];
        System.arraycopy(answer, 0, nums, 0, n);
    }
    public static void reverse(int[] arr, int start, int end) {
        int temp;
        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateWithoutExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // [1,2,3,4,5,6,7], k=3 -> Reverse -> [7,6,5,4,3,2,1]
        reverse(nums, 0, n-1);
        // Reverse -> 0 to k [5,6,7], Reverse k to n [1,2,3,4]
        reverse(nums, 0, k-1);
        // Answer --> [5,6,7,1,2,3,4]
        reverse(nums, k, n-1);
    }
    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};
        rotateWithoutExtraSpace(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = new int[] {1,2,3,4,5,6,7};
        rotateWithoutExtraSpace(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
