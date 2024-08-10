// 2540. Minimum Common Value
package Easy;

public class Easy_2540_Minimum_Common_Value {
    public static int getCommon(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int length1=nums1.length;
        int length2= nums2.length;
        // For faster solution
        if (nums1[length1-1] < nums2[0] || nums2[length2-1] < nums1[0])
            return -1;

        // Two pointer approach
        while (i<length1 && j<length2) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(getCommon(new int[] {1,2,3}, new int[] {2,4}));
        System.out.println(getCommon(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
    }
}
