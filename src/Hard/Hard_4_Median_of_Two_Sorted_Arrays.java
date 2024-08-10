// 4. Median of Two Sorted Arrays
package Hard;

public class Hard_4_Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int n = n1Len + n2Len;
        int[] arr = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < n1Len && j < n2Len) {
            if (nums1[i] <= nums2[j])
                arr[k++] = nums1[i++];
            else arr[k++] = nums2[j++];
        }
        while (i < n1Len) arr[k++] = nums1[i++];
        while (j < n2Len) arr[k++] = nums2[j++];

        if (n % 2 == 0)
            return (arr[n/2] + arr[n/2-1]) / 2.0;
        return arr[n/2];
    }
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
