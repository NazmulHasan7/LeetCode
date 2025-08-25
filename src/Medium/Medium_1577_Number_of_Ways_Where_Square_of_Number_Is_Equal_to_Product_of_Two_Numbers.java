// 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
package Medium;
import java.util.HashMap;

public class Medium_1577_Number_of_Ways_Where_Square_of_Number_Is_Equal_to_Product_of_Two_Numbers {
    public static int numTriplets(int[] nums1, int[] nums2) {
        return getCount(nums1, nums2) + getCount(nums2, nums1);
    }
    private static int getCount(int[] nums1, int[] nums2) {
        int count = 0;
        for (int ni : nums1) {
            long sqr = (long) ni * ni;
            // map -> {nj, count}
            HashMap<Long, Integer> map = new HashMap<>();

            for (int nj : nums2) {
                if (sqr % nj == 0) {
                    long nk = sqr / nj;
                    count += map.getOrDefault(nk, 0);
                }
                map.put((long) nj, map.getOrDefault((long) nj,0)+1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numTriplets(new int[]{7,4}, new int[]{5,2,8,9}));
        System.out.println(numTriplets(new int[]{1,1}, new int[]{1,1,1}));
        System.out.println(numTriplets(new int[]{7,7,8,3}, new int[]{1,2,9,7}));
    }
}
