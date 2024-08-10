// 1299. Replace Elements with Greatest Element on Right Side
package Easy;
import java.util.Arrays;

public class Easy_1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public static int[] replaceElements(int[] arr) {
        int prevMax, max = -1;
        for (int i=arr.length-1; i>=0; i--) {
            prevMax = max;
            if (arr[i] > max)
                max = arr[i];
            arr[i] = prevMax;
        } return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[] {17,18,5,4,6,1})));
        System.out.println(Arrays.toString(replaceElements(new int[] {400})));
    }
}
