// 2433. Find The Original Array of Prefix Xor
package Medium;
import java.util.Arrays;

public class Medium_2433_Find_The_Original_Array_of_Prefix_Xor {
    public static int[] findArray(int[] pref) {
        int length = pref.length;
        int[] arr = new int[length];
        arr[0] = pref[0];

        for (int i=1; i<length; i++)
            arr[i] = pref[i-1] ^ pref[i];
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[] {5,2,0,3,1})));
        System.out.println(Arrays.toString(findArray(new int[] {13})));
    }
}
