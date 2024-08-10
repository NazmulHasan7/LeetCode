// 75. Sort Colors
package Medium;
import java.util.Arrays;

public class Medium_75_Sort_Colors {
    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int x : nums) freq[x]++;
        int i = 0;
        while (freq[0]-- != 0) nums[i++] = 0;
        while (freq[1]-- != 0) nums[i++] = 1;
        while (freq[2]-- != 0) nums[i++] = 2;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {2,0,2,1,1,0};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
