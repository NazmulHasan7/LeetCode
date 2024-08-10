// 1855. Maximum Distance Between a Pair of Values
package Medium;

public class Medium_1855_Maximum_Distance_Between_a_Pair_of_Values {
    public static int maxDistance(int[] nums1, int[] nums2) {
        int n1Ptr = 0, n2Ptr = 0;
        int maxDistance = Integer.MIN_VALUE;
        while (n1Ptr < nums1.length && n2Ptr < nums2.length) {
            if (n1Ptr <= n2Ptr) {
                if (nums1[n1Ptr] <= nums2[n2Ptr]) {
                    maxDistance = Math.max(maxDistance, n2Ptr - n1Ptr);
                    n2Ptr++;
                } else n1Ptr++;
            } else n2Ptr++;
        } return maxDistance;
    }
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println(maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
    }
}
