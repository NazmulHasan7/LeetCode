// 1846. Maximum Element After Decreasing and Rearranging
package Medium;
import java.util.Arrays;

public class Medium_1846_Maximum_Element_After_Decreasing_and_Rearranging {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int max = 1;
        arr[0] = 1;
        for (int i=1; i<n; i++) {
            if (arr[i] - arr[i-1] <= 1) {
                max = Math.max(max, arr[i]);
            } else {
                arr[i] = arr[i-1] + 1;
                max = arr[i];
            }
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
