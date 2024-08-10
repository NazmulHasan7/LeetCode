// 88. Merge Sorted Array
package Easy;
import java.util.Arrays;

public class Easy_88_Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length-1;
        m--; n--;
        while (m>=0 && n>=0) {
            if (nums1[m] >= nums2[n])
                nums1[idx--] = nums1[m--];
            else nums1[idx--] = nums2[n--];
        } while (n>=0) nums1[idx--] = nums2[n--];
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
        int[] arr3 = {1};
        int[] arr4 = {};
        merge(arr3, 1, arr4, 0);
        System.out.println(Arrays.toString(arr3));
    }
}
