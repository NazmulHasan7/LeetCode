// 2570. Merge Two 2D Arrays by Summing Values
package Easy;
import java.util.Arrays;

public class Easy_2570_Merge_Two_2D_Arrays_by_Summing_Values {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] result = new int[len1+len2][2];

        int idx1 = 0, idx2 = 0, index = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1][0] == nums2[idx2][0]) {
                result[index][0] = nums1[idx1][0];
                result[index][1] = nums1[idx1][1] + nums2[idx2][1];
                idx1++;
                idx2++;
            } else if (nums1[idx1][0] < nums2[idx2][0]) {
                result[index] = nums1[idx1];
                idx1++;
            } else {
                result[index] = nums2[idx2];
                idx2++;
            } index++;
        }
        while (idx1 < len1)
            result[index++] = nums1[idx1++];
        while (idx2 < len2)
            result[index++] = nums2[idx2++];
        return Arrays.copyOf(result, index);
    }
    public static void main(String[] args) {
        int[][] result = mergeArrays(new int[][] {{1,2},{2,3},{4,5}}, new int[][] {{1,4},{3,2},{4,1}});
        for (int[] r : result)
            System.out.println(Arrays.toString(r));
        System.out.println();
        result = mergeArrays(new int[][] {{2,4},{3,6},{5,5}}, new int[][] {{1,3},{4,3}});
        for (int[] r : result)
            System.out.println(Arrays.toString(r));
    }
}
